package com.dhkim.mvvminsta.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.dhkim.mvvminsta.R
import com.dhkim.mvvminsta.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding : ActivityLoginBinding
    lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        binding.viewModel = loginViewModel
        binding.activity = this
        binding.lifecycleOwner = this
    }

    fun findId() {

    }

    fun loginFacebook() {

    }
}