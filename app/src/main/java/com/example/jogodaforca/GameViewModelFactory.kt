package com.example.jogodaforca

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
/*
class GameViewModelFactory(private val allWords: Set<String>) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameViewModel::class.java)) {
            return GameViewModel(allWords) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
 */