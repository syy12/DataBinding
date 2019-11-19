package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //lateinit = late initialise
    private lateinit var binding: ActivityMainBinding

    private var contact: Contact = Contact("See","012-3456789")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main)

        binding.myContact = contact

        binding.buttonDone.setOnClickListener {
            updateName()
        }


    }

    fun updateName() {

        //apply = multiple setter on a single object

        binding.apply{
            contact?.name = editTextName.text.toString()
            contact?.phone = editTextPhone.text.toString()
            this.invalidateAll()
        }
    }
}
