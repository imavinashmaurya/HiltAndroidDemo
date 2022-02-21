package com.example.demoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.demoapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity2 : AppCompatActivity() {

    @Inject
    lateinit var indianFood: IndianFood

    @Inject
    lateinit var chineseFood: ChineseFood

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btIndian.setOnClickListener {
            binding.tvStatus.text =
                "Food Details:${indianFood.foodType()},${indianFood.foodCount()}"
            indianFood.specialFood()
        }
        binding.btChinese.setOnClickListener {
            binding.tvStatus.text =
                "Food Details:${chineseFood.foodType()},${chineseFood.foodCount()}"
        }
    }
}