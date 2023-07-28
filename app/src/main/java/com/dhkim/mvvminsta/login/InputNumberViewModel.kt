package com.dhkim.mvvminsta.login

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

data class FindIdModel(var id : String? = null, var phoneNumber : String? = null)
class InputNumberViewModel : ViewModel() {
    var auth = FirebaseAuth.getInstance()
    var firestore = FirebaseFirestore.getInstance()
    var nextPage = MutableLiveData(false)
    var inputNumber = ""

    fun savePhoneNumber() {
        println("inputNumber1111 -> $inputNumber")
        var findIdModel = FindIdModel(auth.currentUser?.email, inputNumber)
        firestore.collection("findIds").document().set(findIdModel).addOnCompleteListener {
            if (it.isSuccessful) {
                nextPage.value = true
                auth.currentUser?.sendEmailVerification()
            }
        }
    }
}