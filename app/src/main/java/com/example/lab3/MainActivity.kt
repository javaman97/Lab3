package com.example.lab3

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        binding.btnNext.setOnClickListener {
            val name = binding.edtText.text.toString()
            val intent = Intent(this, NameActivity::class.java)
            intent.putExtra("name",name)
            startActivityForResult(intent, 1)
        }

        val savedName = sharedPreferences.getString("name", "")
        binding.edtText.setText(savedName)
    }

    override fun onPause() {
        super.onPause()
        val name = binding.edtText.text.toString()
        val editor = sharedPreferences.edit()
        editor.putString("name", name)
        editor.apply()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == 0) {
            // User wants to change their name
            // Handle the logic here
        } else if (resultCode == 1) {
            // User is happy, close the app
            finish()
        }
    }
}
