package com.dhkim.mvvminsta.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.dhkim.mvvminsta.R
import com.dhkim.mvvminsta.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    lateinit var auth : FirebaseAuth
    lateinit var binding : ActivityLoginBinding
    val loginViewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.viewModel = loginViewModel
        binding.activity = this
        binding.lifecycleOwner = this
        auth = FirebaseAuth.getInstance()
        setObserve()
    }

    fun setObserve() {
        loginViewModel.showInputNumberActivity.observe(this) {
            if (it) {
                finish()
                startActivity(Intent(this, InputNumberActivity::class.java))
            }
        }
        loginViewModel.showFindIdActivity.observe(this) {
            if (it) {
                startActivity(Intent(this, FindIdActivity::class.java))
            }
        }
    }

    fun loginWithSignupEmail() {
        auth.createUserWithEmailAndPassword(loginViewModel.id.value.toString(), loginViewModel.password.value.toString())
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    loginViewModel.showInputNumberActivity.value = true
                } else {
                    // id 있을 경우

                }
            }
    }

    fun findId() {
        loginViewModel.showFindIdActivity.value = true
    }

    fun loginFacebook() {

    }
}