package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab3.databinding.ActivityNameBinding

class NameActivity : AppCompatActivity() {
   private lateinit var binding:ActivityNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        binding.txtWelcome.text = "Welcome $name!"

        binding.btnThankYou.setOnClickListener {
            setResult(1)
            finish()
        }

        binding.btnDontCallMeThat.setOnClickListener {
            setResult(0)
            finish()
        }
    }
}
