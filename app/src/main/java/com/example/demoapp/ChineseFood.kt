package com.example.demoapp

import android.util.Log

class ChineseFood : Food() {
    private var foodCount = 0
    override fun foodType(): String {
        Log.e("ChineseFood", "foodType: Chinese")
        return "Chinese"
    }

    override fun foodCount(): String {
        Log.e("ChineseFood", "foodCount: $foodCount")
        return "${foodCount++}"
    }
}