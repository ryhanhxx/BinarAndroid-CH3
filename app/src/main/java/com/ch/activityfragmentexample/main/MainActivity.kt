package com.ch.activityfragmentexample.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ch.activityfragmentexample.R
import com.ch.activityfragmentexample.databinding.ActivityMainBinding
import com.ch.activityfragmentexample.presentation.fragmentone.FragmentOne
import com.ch.activityfragmentexample.presentation.fragmentthree.FragmentThree
import com.ch.activityfragmentexample.presentation.fragmenttwo.FragmentTwo

class MainActivity : AppCompatActivity() {

    private val fragmentOne: FragmentOne by lazy { FragmentOne() }
    private val fragmentTwo: FragmentTwo by lazy { FragmentTwo() }
    private val fragmentThree: FragmentThree by lazy { FragmentThree() }

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setClickButtonNavigate()
        replaceFragment(fragmentOne)
    }

    private fun setClickButtonNavigate() {
        binding.btnFragment1.setOnClickListener {
            replaceFragment(fragmentOne)
        }
        binding.btnFragment2.setOnClickListener {
            replaceFragment(fragmentTwo)
        }
        binding.btnFragment3.setOnClickListener {
            replaceFragment(fragmentThree)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.flContainer.id, fragment)
            .commit()
    }
}