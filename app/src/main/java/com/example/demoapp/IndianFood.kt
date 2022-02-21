package com.example.demoapp

import android.util.Log

class IndianFood : Food() {
    private var foodCount = 0
    override fun foodType(): String {
        Log.e("IndianFood", "foodType: Indian")
        return "Indian"
    }

    override fun foodCount(): String {
        Log.e("IndianFood", "foodCount: $foodCount")
        return "${foodCount++}"
    }
}