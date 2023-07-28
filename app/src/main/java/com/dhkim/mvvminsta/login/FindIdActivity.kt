package com.dhkim.mvvminsta.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.dhkim.mvvminsta.R
import com.dhkim.mvvminsta.databinding.ActivityFindIdBinding

class FindIdActivity : AppCompatActivity() {
    lateinit var binding : ActivityFindIdBinding
    val findIdViewModel : FindIdViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_find_id)
        binding.activity = this
        binding.viewModel = findIdViewModel
        binding.lifecycleOwner = this
        setObserve()
    }
    fun setObserve() {
        findIdViewModel.toastMessage.observe(this) {
            if (it.isNotEmpty()) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }
    }
}