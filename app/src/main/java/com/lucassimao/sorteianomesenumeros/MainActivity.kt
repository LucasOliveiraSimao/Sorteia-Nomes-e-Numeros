package com.lucassimao.sorteianomesenumeros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucassimao.sorteianomesenumeros.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNumbers.setOnClickListener {
            Intent(this, DrawNumbersActivity::class.java).apply {
                startActivity(this)
            }
        }

    }
}