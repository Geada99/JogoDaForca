package com.example.jogodaforca

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.jogodaforca.allWords

class GameViewModel(allWords: Set<String>) : ViewModel() {

    private lateinit var currentWord: String   // lateinit permite a inicialização da palavra mais tarde
    private val usedWords = mutableListOf<String>()

    private val _hiddenWord = MutableStateFlow("")
    val hiddenWord: StateFlow<String> get() = _hiddenWord.asStateFlow()

    init {
        resetGame()
    }

    private fun resetGame(){
        usedWords.clear()
        _hiddenWord.value = pickRandomWordAndHide()
    }

    private fun pickRandomWordAndHide(): String {
        // Escolhe uma palavra nova
        do {
            currentWord = allWords.random()   // Escolhe uma palavra random da lista de palavras em Words
        } while (usedWords.contains(currentWord))

        usedWords.add(currentWord)
        return hideCurrentWord(currentWord)
    }

    private fun hideCurrentWord(word: String): String {
        // Cria uma string com "_ " repetidos pelo tamanho da palavra
        val hiddenWord = "_ ".repeat(word.length).trim()

        return hiddenWord
    }
}