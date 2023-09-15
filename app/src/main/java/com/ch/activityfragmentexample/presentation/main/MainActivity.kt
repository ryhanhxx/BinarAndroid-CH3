package com.ch.activityfragmentexample.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ch.activityfragmentexample.R
import com.ch.activityfragmentexample.databinding.ActivityMainBinding
import com.ch.activityfragmentexample.presentation.fragmentone.FragmentOne
import com.ch.activityfragmentexample.presentation.fragmentthree.FragmentThree
import com.ch.activityfragmentexample.presentation.fragmenttwo.FragmentTwo

class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}