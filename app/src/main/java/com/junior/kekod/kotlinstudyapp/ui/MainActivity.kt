package com.junior.kekod.kotlinstudyapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.junior.kekod.kotlinstudyapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}