package com.example.rpuppies;

import android.os.AsyncTask;
import com.googlecode.flickrjandroid.Flickr;
import com.googlecode.flickrjandroid.photos.PhotoList;
import com.googlecode.flickrjandroid.photos.SearchParameters;

public class PhotoUtils extends AsyncTask<Integer, Void, Void> {

    private Flickr f;

    private SearchParameters puppyParams;

    private PhotoList puppyPhotoList;

    private final Integer PER_PAGE = 50;

    public PhotoUtils() {
        this.f = new Flickr(BuildConfig.FLICKR_API_KEY, BuildConfig.FLICKR_API_SECRET);
        this.puppyParams = new SearchParameters();
    }

    private void getPuppyPhotoList(Integer page) {
        this.puppyPhotoList = null;
        this.puppyParams.setText("kitten");
        String[] tags = {"kitten","cats", "kittens", "cat"};
        this.puppyParams.setTags(tags);
        try {
            this.puppyPhotoList = this.f.getPhotosInterface().search(this.puppyParams, PER_PAGE, page);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getUrl() {
        int puppyPhotoNumber = generateRandomNumberWithBounds(PER_PAGE);
        if(puppyPhotoList != null){
            StringBuilder sb = new StringBuilder("https://farm1.staticflickr.com/");
            sb.append(puppyPhotoList.get(puppyPhotoNumber).getServer());
            sb.append("/");
            sb.append(puppyPhotoList.get(puppyPhotoNumber).getId());
            sb.append("_");
            sb.append(puppyPhotoList.get(puppyPhotoNumber).getSecret());
            sb.append(".jpg");
            return sb.toString();
        } else {
            return "";
        }

    }

    private Integer generateRandomNumberWithBounds(Integer upperBound){
        System.out.println("Random number" + Integer.toString((int )(Math.random() * upperBound)));
        return (int )(Math.random() * upperBound);
    }

    @Override
    protected Void doInBackground(Integer... pParams) {
        getPuppyPhotoList(pParams[0]);
        return null;
    }

}
