package com.michaelrichards.pagepal.screens.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {

    val username: MutableState<String> = mutableStateOf("")
    val password: MutableState<String> = mutableStateOf("")
    val isError: MutableState<Boolean> = mutableStateOf(false)
    val isEnabled: MutableState<Boolean> = mutableStateOf(true)

    var isLoading by mutableStateOf(false)
        private set

    fun login(){
        viewModelScope.launch (
            Dispatchers.IO
        ){
            if (!isLoading){
                isLoading = true
                delay(5000L)
                isLoading = false
            }
        }

    }


}