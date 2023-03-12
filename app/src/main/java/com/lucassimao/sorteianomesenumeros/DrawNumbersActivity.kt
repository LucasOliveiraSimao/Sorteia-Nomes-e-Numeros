package com.lucassimao.sorteianomesenumeros

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lucassimao.sorteianomesenumeros.databinding.ActivityDrawNumbersBinding

class DrawNumbersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDrawNumbersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrawNumbersBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}