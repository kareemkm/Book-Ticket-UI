package com.task.booktiket.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthViewModel:ViewModel() {

    private val firebaseAuth :FirebaseAuth = FirebaseAuth.getInstance()

    fun register(email:String,password:String,onResult: (Boolean)-> Unit){
        viewModelScope.launch(Dispatchers.IO) {
            firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener { success ->
                    onResult(success.isSuccessful)
                }
        }
    }

    fun login(email: String,password: String,onResult: (Boolean) -> Unit){
        viewModelScope.launch(Dispatchers.IO) {
            firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener { success ->
                    onResult(success.isSuccessful)
                }
        }
    }

    fun getCurrentUser() = firebaseAuth.currentUser

    fun signOut(){
        firebaseAuth.signOut()
    }

}