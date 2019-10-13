
package com.example.rpuppies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button;


class MainActivity : AppCompatActivity() {

    private lateinit var puppyBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        puppyBtn = findViewById(R.id.new_puppy_button)

        addListenerOnPuppyButton()
    }

    fun addListenerOnPuppyButton() {

        puppyBtn.setOnClickListener {
            print("New puppy button clicked!")
        }
    }
}
