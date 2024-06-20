package com.example.jogodaforca

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.example.jogodaforca.allWords


class GameViewModel(
    private val allWords: Set<String>
) : ViewModel() {

    private lateinit var currentWord: String
    private val usedWords = mutableListOf<String>()

    private val _hiddenWord = MutableStateFlow("")
    val hiddenWord: StateFlow<String> get() = _hiddenWord.asStateFlow()

    init {
        resetGame()
    }

    private fun resetGame() {
        usedWords.clear()
        _hiddenWord.value = pickRandomWordAndHide()
        resetKeyboard()
    }

    fun newWord() {
        _hiddenWord.value = pickRandomWordAndHide()
        resetKeyboard()
    }

    private fun pickRandomWordAndHide(): String {
        do {
            currentWord = allWords.random()
        } while (usedWords.contains(currentWord))

        usedWords.add(currentWord)
        return hideCurrentWord(currentWord)
    }

    private fun hideCurrentWord(word: String): String {
        return "_ ".repeat(word.length).trim()
    }

    fun checkLetter(letter: String, onLetterClick: (Color) -> Unit) {
        val hiddenWordValue = currentWord
        val hiddenWordBuilder = StringBuilder(_hiddenWord.value)
        var found = false
        var errors = 0
        var correctGuesses = 0

        hiddenWordValue.forEachIndexed { index, char ->
            if (char.equals(letter[0], ignoreCase = true)) {
                hiddenWordBuilder.setCharAt(2 * index, char) // Para compensar o facto de haver espaço entre as letras
                found = true
            }
        }

        _hiddenWord.value = hiddenWordBuilder.toString()

        if (found) {
            onLetterClick(Color.Green)
            if (correctGuesses == currentWord.length) {
                // endGame(true)
            } else {
                correctGuesses++
            }
        } else {
            onLetterClick(Color.Red)
            if (errors == 8) {
                // endGame(false)
            } else {
                errors++
            }
        }
    }

    var boxQClicked by mutableStateOf(false)
    var boxQBackgroundColor by mutableStateOf(Color.Gray)

    var boxWClicked by mutableStateOf(false)
    var boxWBackgroundColor by mutableStateOf(Color.Gray)

    var boxEClicked by mutableStateOf(false)
    var boxEBackgroundColor by mutableStateOf(Color.Gray)

    var boxRClicked by mutableStateOf(false)
    var boxRBackgroundColor by mutableStateOf(Color.Gray)

    var boxTClicked by mutableStateOf(false)
    var boxTBackgroundColor by mutableStateOf(Color.Gray)

    var boxYClicked by mutableStateOf(false)
    var boxYBackgroundColor by mutableStateOf(Color.Gray)

    var boxUClicked by mutableStateOf(false)
    var boxUBackgroundColor by mutableStateOf(Color.Gray)

    var boxIClicked by mutableStateOf(false)
    var boxIBackgroundColor by mutableStateOf(Color.Gray)

    var boxOClicked by mutableStateOf(false)
    var boxOBackgroundColor by mutableStateOf(Color.Gray)

    var boxPClicked by mutableStateOf(false)
    var boxPBackgroundColor by mutableStateOf(Color.Gray)

    var boxAClicked by mutableStateOf(false)
    var boxABackgroundColor by mutableStateOf(Color.Gray)

    var boxSClicked by mutableStateOf(false)
    var boxSBackgroundColor by mutableStateOf(Color.Gray)

    var boxDClicked by mutableStateOf(false)
    var boxDBackgroundColor by mutableStateOf(Color.Gray)

    var boxFClicked by mutableStateOf(false)
    var boxFBackgroundColor by mutableStateOf(Color.Gray)

    var boxGClicked by mutableStateOf(false)
    var boxGBackgroundColor by mutableStateOf(Color.Gray)

    var boxHClicked by mutableStateOf(false)
    var boxHBackgroundColor by mutableStateOf(Color.Gray)

    var boxJClicked by mutableStateOf(false)
    var boxJBackgroundColor by mutableStateOf(Color.Gray)

    var boxKClicked by mutableStateOf(false)
    var boxKBackgroundColor by mutableStateOf(Color.Gray)

    var boxLClicked by mutableStateOf(false)
    var boxLBackgroundColor by mutableStateOf(Color.Gray)

    var boxÇClicked by mutableStateOf(false)
    var boxÇBackgroundColor by mutableStateOf(Color.Gray)

    var boxZClicked by mutableStateOf(false)
    var boxZBackgroundColor by mutableStateOf(Color.Gray)

    var boxXClicked by mutableStateOf(false)
    var boxXBackgroundColor by mutableStateOf(Color.Gray)

    var boxCClicked by mutableStateOf(false)
    var boxCBackgroundColor by mutableStateOf(Color.Gray)

    var boxVClicked by mutableStateOf(false)
    var boxVBackgroundColor by mutableStateOf(Color.Gray)

    var boxBClicked by mutableStateOf(false)
    var boxBBackgroundColor by mutableStateOf(Color.Gray)

    var boxNClicked by mutableStateOf(false)
    var boxNBackgroundColor by mutableStateOf(Color.Gray)

    var boxMClicked by mutableStateOf(false)
    var boxMBackgroundColor by mutableStateOf(Color.Gray)

    fun resetKeyboard() {
        viewModelScope.launch {
            boxQClicked = false
            boxQBackgroundColor = Color.Gray
            boxWClicked = false
            boxWBackgroundColor = Color.Gray
            boxEClicked = false
            boxEBackgroundColor = Color.Gray
            boxRClicked = false
            boxRBackgroundColor = Color.Gray
            boxTClicked = false
            boxTBackgroundColor = Color.Gray
            boxYClicked = false
            boxYBackgroundColor = Color.Gray
            boxUClicked = false
            boxUBackgroundColor = Color.Gray
            boxIClicked = false
            boxIBackgroundColor = Color.Gray
            boxOClicked = false
            boxOBackgroundColor = Color.Gray
            boxPClicked = false
            boxPBackgroundColor = Color.Gray
            boxAClicked = false
            boxABackgroundColor = Color.Gray
            boxSClicked = false
            boxSBackgroundColor = Color.Gray
            boxDClicked = false
            boxDBackgroundColor = Color.Gray
            boxFClicked = false
            boxFBackgroundColor = Color.Gray
            boxGClicked = false
            boxGBackgroundColor = Color.Gray
            boxHClicked = false
            boxHBackgroundColor = Color.Gray
            boxJClicked = false
            boxJBackgroundColor = Color.Gray
            boxKClicked = false
            boxKBackgroundColor = Color.Gray
            boxLClicked = false
            boxLBackgroundColor = Color.Gray
            boxÇClicked = false
            boxÇBackgroundColor = Color.Gray
            boxZClicked = false
            boxZBackgroundColor = Color.Gray
            boxXClicked = false
            boxXBackgroundColor = Color.Gray
            boxCClicked = false
            boxCBackgroundColor = Color.Gray
            boxVClicked = false
            boxVBackgroundColor = Color.Gray
            boxBClicked = false
            boxBBackgroundColor = Color.Gray
            boxNClicked = false
            boxNBackgroundColor = Color.Gray
            boxMClicked = false
            boxMBackgroundColor = Color.Gray
        }
    }
}

    /*
    fun endGame(Win: ){

    }
     */

