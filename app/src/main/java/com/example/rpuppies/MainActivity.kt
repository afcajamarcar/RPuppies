package com.example.rpuppies


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import kotlin.properties.Delegates
import java.util.Timer
import kotlin.concurrent.schedule


class MainActivity : AppCompatActivity() {

    private lateinit var puppyBtn: Button

    private lateinit var photoArtifact: PhotoUtils

    private var pageNumber: Int = 1

    private var clicks: Int by Delegates.observable(0) { property, oldValue, newValue ->
        System.out.println("Clicks " + newValue)
        if (newValue == 10) {
            pageNumber+=1
            clicks=0
            initPhotoArtifact(pageNumber)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        puppyBtn = findViewById(R.id.new_puppy_button)

        initPhotoArtifact(pageNumber)

        addListenerOnPuppyButton()
    }

    fun addListenerOnPuppyButton() {

        puppyBtn.setOnClickListener {
            Glide
                .with(this)
                .load(photoArtifact.getUrl()).transition(withCrossFade())
                .into(findViewById(R.id.animal_photo_container))
            clicks += 1
        }
    }

    fun initPhotoArtifact(newPageNumber: Int){

        photoArtifact = PhotoUtils()

        photoArtifact.execute(newPageNumber)
    }

}
