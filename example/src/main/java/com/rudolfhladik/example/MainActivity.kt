package com.rudolfhladik.example

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.rudolfhladik.example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel

        viewModel.btnOneClickAction.observeForever {
            showSnack(it)
        }

        viewModel.btnTwoClickAction.observeForever {
            showSnack(it)
        }
    }

    private fun showSnack(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
