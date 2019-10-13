package com.example.rpuppies;

import android.os.AsyncTask;
import com.googlecode.flickrjandroid.Flickr;
import com.googlecode.flickrjandroid.photos.PhotoList;
import com.googlecode.flickrjandroid.photos.SearchParameters;

public class PhotoUtils extends AsyncTask<Void, Void, String> {

    private Flickr f;

    private String baseUrl = "";

    private SearchParameters puppyParams;

    public PhotoUtils() {
        this.f = new Flickr(BuildConfig.FLICKR_API_KEY, BuildConfig.FLICKR_API_SECRET);
        this.puppyParams = new SearchParameters();
    }

    public PhotoList getPuppyPhotoList() {
        PhotoList puppyPhotoList = null;
        this.puppyParams.setText("puppies");
        try {
            puppyPhotoList = this.f.getPhotosInterface().search(this.puppyParams, 50, 1);
            System.out.println("Total of puppies " + puppyPhotoList.getTotal());
        } catch(Exception e){
            e.printStackTrace();
        }
        return puppyPhotoList;
    }

    @Override
    protected String doInBackground(Void... voids) {

        return "Total of puppies " + getPuppyPhotoList().getTotal();

    }
}
