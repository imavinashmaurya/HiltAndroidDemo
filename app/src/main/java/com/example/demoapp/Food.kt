package com.example.demoapp

import android.util.Log


abstract class Food {
    abstract fun foodType():String
    abstract fun foodCount():String

    fun specialFood(){
        Log.e("Food", "specialFood")
    }
}