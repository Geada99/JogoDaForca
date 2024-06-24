package com.example.jogodaforca

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {

    private lateinit var _currentWord: String
    private val _usedWords = mutableListOf<String>()

    private val _hiddenWord = MutableStateFlow("")
    val hiddenWord: StateFlow<String> get() = _hiddenWord

    private val _currentHint = MutableStateFlow("")
    val currentHint: StateFlow<String> get() = _currentHint

    val errors = MutableStateFlow(0)
    private val _currentImageIndex = MutableStateFlow(0)
    private val _correctGuesses = MutableStateFlow(0)
    val correctGuesses: StateFlow<Int> get() = _correctGuesses

    private val _hangmanDrawing = listOf(
        R.drawable.hangman_picture_1,
        R.drawable.hangman_picture_2,
        R.drawable.hangman_picture_3,
        R.drawable.hangman_picture_4,
        R.drawable.hangman_picture_5,
        R.drawable.hangman_picture_6,
        R.drawable.hangman_picture_7,
        R.drawable.hangman_picture_8
    )

    // Variables for keyboard reset
    var boxQClicked: Boolean by mutableStateOf(false)
    var boxQBackgroundColor: Color by mutableStateOf(Color.Gray)

    var boxWClicked: Boolean by mutableStateOf(false)
    var boxWBackgroundColor: Color by mutableStateOf(Color.Gray)

    var boxEClicked: Boolean by mutableStateOf(false)
    var boxEBackgroundColor: Color by mutableStateOf(Color.Gray)

    var boxRClicked: Boolean by mutableStateOf(false)
    var boxRBackgroundColor: Color by mutableStateOf(Color.Gray)

    var boxTClicked: Boolean by mutableStateOf(false)
    var boxTBackgroundColor: Color by mutableStateOf(Color.Gray)

    var boxYClicked: Boolean by mutableStateOf(false)
    var boxYBackgroundColor: Color by mutableStateOf(Color.Gray)

    var boxUClicked: Boolean by mutableStateOf(false)
    var boxUBackgroundColor: Color by mutableStateOf(Color.Gray)

    var boxIClicked: Boolean by mutableStateOf(false)
    var boxIBackgroundColor: Color by mutableStateOf(Color.Gray)

    var boxOClicked: Boolean by mutableStateOf(false)
    var boxOBackgroundColor: Color by mutableStateOf(Color.Gray)

    var boxPClicked: Boolean by mutableStateOf(false)
    var boxPBackgroundColor: Color by mutableStateOf(Color.Gray)

    var boxAClicked: Boolean by mutableStateOf(false)
    var boxABackgroundColor: Color by mutableStateOf(Color.Gray)

    var boxSClicked: Boolean by mutableStateOf(false)
    var boxSBackgroundColor: Color by mutableStateOf(Color.Gray)

    var boxDClicked: Boolean by mutableStateOf(false)
    var boxDBackgroundColor: Color by mutableStateOf(Color.Gray)

    var boxFClicked: Boolean by mutableStateOf(false)
    var boxFBackgroundColor: Color by mutableStateOf(Color.Gray)

    var boxGClicked: Boolean by mutableStateOf(false)
    var boxGBackgroundColor: Color by mutableStateOf(Color.Gray)

    var boxHClicked: Boolean by mutableStateOf(false)
    var boxHBackgroundColor: Color by mutableStateOf(Color.Gray)

    var boxJClicked: Boolean by mutableStateOf(false)
    var boxJBackgroundColor: Color by mutableStateOf(Color.Gray)

    var boxKClicked: Boolean by mutableStateOf(false)
    var boxKBackgroundColor: Color by mutableStateOf(Color.Gray)

    var boxLClicked: Boolean by mutableStateOf(false)
    var boxLBackgroundColor: Color by mutableStateOf(Color.Gray)

    var boxCedilhaClicked: Boolean by mutableStateOf(false)
    var boxCedilhaBackgroundColor: Color by mutableStateOf(Color.Gray)

    var boxZClicked: Boolean by mutableStateOf(false)
    var boxZBackgroundColor: Color by mutableStateOf(Color.Gray)

    var boxXClicked: Boolean by mutableStateOf(false)
    var boxXBackgroundColor: Color by mutableStateOf(Color.Gray)

    var boxCClicked: Boolean by mutableStateOf(false)
    var boxCBackgroundColor: Color by mutableStateOf(Color.Gray)

    var boxVClicked: Boolean by mutableStateOf(false)
    var boxVBackgroundColor: Color by mutableStateOf(Color.Gray)

    var boxBClicked: Boolean by mutableStateOf(false)
    var boxBBackgroundColor: Color by mutableStateOf(Color.Gray)

    var boxNClicked: Boolean by mutableStateOf(false)
    var boxNBackgroundColor: Color by mutableStateOf(Color.Gray)

    var boxMClicked: Boolean by mutableStateOf(false)
    var boxMBackgroundColor: Color by mutableStateOf(Color.Gray)

    init {
        resetGame()
    }

    private fun resetGame() {
        _usedWords.clear()
        _hiddenWord.value = pickRandomWordAndHide()
        errors.value = 0
        _correctGuesses.value = 0
        _currentImageIndex.value = 0
        resetKeyboard()
    }

    fun newWord() {
        _hiddenWord.value = pickRandomWordAndHide()
        errors.value = 0
        _correctGuesses.value = 0
        _currentImageIndex.value = 0
        resetKeyboard()
    }

    private fun incrementErrors() {
        errors.value++
        swapImage()
    }

    fun getCurrentImageResource(): Int {
        return _hangmanDrawing[_currentImageIndex.value]
    }

    private fun swapImage() {
        _currentImageIndex.value = errors.value.coerceAtMost(_hangmanDrawing.size - 1)
    }

    private fun pickRandomWordAndHide(): String {
        do {
            _currentWord = allWords.random()
        } while (_usedWords.contains(_currentWord))

        _usedWords.add(_currentWord)
        _currentHint.value = wordHints[allWords.indexOf(_currentWord)]

        return hideCurrentWord(_currentWord)
    }

    private fun hideCurrentWord(word: String): String {
        _correctGuesses.value = 0
        return "_ ".repeat(word.length).trim()
    }

    fun checkLetter(letter: String, onLetterClick: (Color) -> Unit) {
        val hiddenWordValue = _currentWord
        val hiddenWordBuilder = StringBuilder(_hiddenWord.value)
        var found = false

        hiddenWordValue.forEachIndexed { index, char ->
            if (char.equals(letter[0], ignoreCase = true)) {
                hiddenWordBuilder.setCharAt(2 * index, char) // Para compensar o espaço entre as letras
                found = true
                _correctGuesses.value++
            }
        }

        _hiddenWord.value = hiddenWordBuilder.toString()

        if (found) {
            onLetterClick(Color.Green)
        } else {
            incrementErrors()
            onLetterClick(Color.Red)
        }
    }

    fun revealWord() {
        val hiddenWordBuilder = StringBuilder()

        _currentWord.forEachIndexed { _, char ->
            if (char == ' ') {
                hiddenWordBuilder.append("  ") // Adiciona dois espaços para manter a formatação original
            } else {
                hiddenWordBuilder.append(char).append(" ")
            }
        }

        _hiddenWord.value = hiddenWordBuilder.toString().trim()
    }

    private fun resetKeyboard() {
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

            boxCedilhaClicked = false
            boxCedilhaBackgroundColor = Color.Gray

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

    fun blockKeyboard() {
        viewModelScope.launch {
            boxQClicked = false
            boxQBackgroundColor = Color.Gray

            boxWClicked = true
            boxEClicked = true
            boxRClicked = true
            boxTClicked = true
            boxYClicked = true
            boxUClicked = true
            boxIClicked = true
            boxOClicked = true
            boxPClicked = true
            boxAClicked = true
            boxSClicked = true
            boxDClicked = true
            boxFClicked = true
            boxGClicked = true
            boxHClicked = true
            boxJClicked = true
            boxKClicked = true
            boxLClicked = true
            boxCedilhaClicked = true
            boxZClicked = true
            boxXClicked = true
            boxCClicked = true
            boxVClicked = true
            boxBClicked = true
            boxNClicked = true
            boxMClicked = true
        }
    }
}
