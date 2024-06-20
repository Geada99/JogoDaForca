import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameViewModel(private val allWords: Set<String>) : ViewModel() {

    private lateinit var currentWord: String
    private val usedWords = mutableListOf<String>()

    private var _hiddenWord = MutableStateFlow("")
    val hiddenWord: StateFlow<String> get() = _hiddenWord.asStateFlow()

    init {
        resetGame()
    }

    private fun resetGame() {
        usedWords.clear()
        _hiddenWord.value = pickRandomWordAndHide()
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

    // Função para verificar se a letra está na palavra escondida e atualizar a cor de fundo da caixa
    fun checkLetter(letter: String, onLetterClick: (Color) -> Unit) {
        val hiddenWordValue = currentWord
        val hiddenWordBuilder = StringBuilder(_hiddenWord.value)
        var found = false


        hiddenWordValue.forEachIndexed { index, char ->
            if (char.equals(letter[0], ignoreCase = true)) {
                hiddenWordBuilder.setCharAt(2 * index, char) // Para compensar o facto de haver espaço entre as letras
                found = true
            }
        }

        _hiddenWord.value = hiddenWordBuilder.toString()

        if (found) {
            onLetterClick(Color.Green)
        } else {
            onLetterClick(Color.Red)

        }
    }
}
