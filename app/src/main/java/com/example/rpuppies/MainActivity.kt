package com.example.rpuppies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.rpuppies.PhotoUtils
import android.util.Log


class MainActivity : AppCompatActivity() {

    private lateinit var puppyBtn: Button

    private lateinit var photoArtifact: PhotoUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        puppyBtn = findViewById(R.id.new_puppy_button)

        addListenerOnPuppyButton()
    }

    fun addListenerOnPuppyButton() {

        puppyBtn.setOnClickListener {
            photoArtifact = PhotoUtils()
            photoArtifact.execute()
            //Log.d("PuppyPhotoListSize", photoArtifact.getPuppyPhotoList().total.toString())
        }
    }
}
