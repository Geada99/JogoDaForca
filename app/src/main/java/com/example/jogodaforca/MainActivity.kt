import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jogodaforca.ui.theme.JogoDaForcaTheme
import com.example.jogodaforca.GameViewModel
import com.example.jogodaforca.R
import com.example.jogodaforca.allWords



class MainActivity : AppCompatActivity() {
    // Propriedade para armazenar o view model
    private lateinit var gameViewModel: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializa o view model com allWords
        gameViewModel = GameViewModel(allWords.toSet())

        // Configura o layout da atividade
        setContent {
            JogoDaForcaTheme {
                GameLayoutScreen(gameViewModel)
            }
        }
    }
}

@Composable
fun GameLayoutScreen(gameViewModel: GameViewModel) {

    val mediumPadding = dimensionResource(R.dimen.padding_medium)

    // Carregar o Array do ficheiro arrays.xml
    val imageArray = stringArrayResource(R.array.image_array)

    // Código milagroso do ChatGPT visto que .toInt() não funciona num array
    val imageResourceId = imageArray.getOrNull(0)?.toIntOrNull() ?: R.drawable.hangman_picture_1

    // Escolha da imagem apresentada
    val imagemForca = painterResource(id = imageResourceId)

    // Usar o gameViewModel recebido como parâmetro para acessar o estado
    val hiddenWord by gameViewModel.hiddenWord.collectAsState()


    Column(
        verticalArrangement = Arrangement.spacedBy(mediumPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(mediumPadding)
            .size(600.dp)
    ) {
        Text(
            text = "Hangman",
            style = MaterialTheme.typography.titleLarge,
            fontSize = 35.sp
        )
        Image(
            modifier = Modifier
                .size(250.dp)
                .padding(mediumPadding * 2),
            painter = imagemForca,
            contentDescription = "Forca"
        )
        Text(
            fontSize = 30.sp,
            text = hiddenWord
        )
        Button(
            modifier = Modifier.padding(mediumPadding),
            onClick = {
                gameViewModel.newWord()
            }) {
            Text(text = "New Word")
        }


        //}


        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Linha 1 de letras Q-W-E-R-T-Y-U-I-O-P
            Row {
                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .padding(3.dp)
                        .clip(shape = RectangleShape)
                        .clickable {
                            if (!gameViewModel.boxQClicked) {
                                gameViewModel.checkLetter("Q") { newColor ->
                                    gameViewModel.boxQBackgroundColor = newColor
                                    gameViewModel.boxQClicked = true
                                }
                            }
                        }
                        .background(gameViewModel.boxQBackgroundColor)
                ) {
                    Text(
                        text = "Q",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .padding(3.dp)
                        .clip(shape = RectangleShape)
                        .clickable {
                            if (!gameViewModel.boxWClicked) {
                                gameViewModel.checkLetter("W") { newColor ->
                                    gameViewModel.boxWBackgroundColor = newColor
                                    gameViewModel.boxWClicked = true
                                }
                            }
                        }
                        .background(gameViewModel.boxWBackgroundColor)
                ) {
                    Text(
                        text = "W",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .padding(3.dp)
                        .clip(shape = RectangleShape)
                        .clickable {
                            if (!gameViewModel.boxEClicked) {
                                gameViewModel.checkLetter("E") { newColor ->
                                    gameViewModel.boxEBackgroundColor = newColor
                                    gameViewModel.boxEClicked = true
                                }
                            }
                        }
                        .background(gameViewModel.boxEBackgroundColor)
                ) {
                    Text(
                        text = "E",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .padding(3.dp)
                        .clip(shape = RectangleShape)
                        .clickable {
                            if (!gameViewModel.boxRClicked) {
                                gameViewModel.checkLetter("R") { newColor ->
                                    gameViewModel.boxRBackgroundColor = newColor
                                    gameViewModel.boxRClicked = true
                                }
                            }
                        }
                        .background(gameViewModel.boxRBackgroundColor)
                ) {
                    Text(
                        text = "R",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .padding(3.dp)
                        .clip(shape = RectangleShape)
                        .clickable {
                            if (!gameViewModel.boxTClicked) {
                                gameViewModel.checkLetter("T") { newColor ->
                                    gameViewModel.boxTBackgroundColor = newColor
                                    gameViewModel.boxTClicked = true
                                }
                            }
                        }
                        .background(gameViewModel.boxTBackgroundColor)
                ) {
                    Text(
                        text = "T",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .padding(3.dp)
                        .clip(shape = RectangleShape)
                        .clickable {
                            if (!gameViewModel.boxYClicked) {
                                gameViewModel.checkLetter("Y") { newColor ->
                                    gameViewModel.boxYBackgroundColor = newColor
                                    gameViewModel.boxYClicked = true
                                }
                            }
                        }
                        .background(gameViewModel.boxYBackgroundColor)
                ) {
                    Text(
                        text = "Y",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .padding(3.dp)
                        .clip(shape = RectangleShape)
                        .clickable {
                            if (!gameViewModel.boxUClicked) {
                                gameViewModel.checkLetter("U") { newColor ->
                                    gameViewModel.boxUBackgroundColor = newColor
                                    gameViewModel.boxUClicked = true
                                }
                            }
                        }
                        .background(gameViewModel.boxUBackgroundColor)
                ) {
                    Text(
                        text = "U",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .padding(3.dp)
                        .clip(shape = RectangleShape)
                        .clickable {
                            if (!gameViewModel.boxIClicked) {
                                gameViewModel.checkLetter("I") { newColor ->
                                    gameViewModel.boxIBackgroundColor = newColor
                                    gameViewModel.boxIClicked = true
                                }
                            }
                        }
                        .background(gameViewModel.boxIBackgroundColor)
                ) {
                    Text(
                        text = "I",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .padding(3.dp)
                        .clip(shape = RectangleShape)
                        .clickable {
                            if (!gameViewModel.boxOClicked) {
                                gameViewModel.checkLetter("O") { newColor ->
                                    gameViewModel.boxOBackgroundColor = newColor
                                    gameViewModel.boxOClicked = true
                                }
                            }
                        }
                        .background(gameViewModel.boxOBackgroundColor)
                ) {
                    Text(
                        text = "O",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .padding(3.dp)
                        .clip(shape = RectangleShape)
                        .clickable {
                            if (!gameViewModel.boxPClicked) {
                                gameViewModel.checkLetter("P") { newColor ->
                                    gameViewModel.boxPBackgroundColor = newColor
                                    gameViewModel.boxPClicked = true
                                }
                            }
                        }
                        .background(gameViewModel.boxPBackgroundColor)
                ) {
                    Text(
                        text = "P",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }
            }

            // Linha 2 de letras A-S-D-F-G-H-J-K-L-Ç
            Row {
                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .padding(3.dp)
                        .clip(shape = RectangleShape)
                        .clickable {
                            if (!gameViewModel.boxAClicked) {
                                gameViewModel.checkLetter("A") { newColor ->
                                    gameViewModel.boxABackgroundColor = newColor
                                    gameViewModel.boxAClicked = true
                                }
                            }
                        }
                        .background(gameViewModel.boxABackgroundColor)
                ) {
                    Text(
                        text = "A",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .padding(3.dp)
                        .clip(shape = RectangleShape)
                        .clickable {
                            if (!gameViewModel.boxSClicked) {
                                gameViewModel.checkLetter("S") { newColor ->
                                    gameViewModel.boxSBackgroundColor = newColor
                                    gameViewModel.boxSClicked = true
                                }
                            }
                        }
                        .background(gameViewModel.boxSBackgroundColor)
                ) {
                    Text(
                        text = "S",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .padding(3.dp)
                        .clip(shape = RectangleShape)
                        .clickable {
                            if (!gameViewModel.boxDClicked) {
                                gameViewModel.checkLetter("D") { newColor ->
                                    gameViewModel.boxDBackgroundColor = newColor
                                    gameViewModel.boxDClicked = true
                                }
                            }
                        }
                        .background(gameViewModel.boxDBackgroundColor)
                ) {
                    Text(
                        text = "D",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .padding(3.dp)
                        .clip(shape = RectangleShape)
                        .clickable {
                            if (!gameViewModel.boxFClicked) {
                                gameViewModel.checkLetter("F") { newColor ->
                                    gameViewModel.boxFBackgroundColor = newColor
                                    gameViewModel.boxFClicked = true
                                }
                            }
                        }
                        .background(gameViewModel.boxFBackgroundColor)
                ) {
                    Text(
                        text = "F",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .padding(3.dp)
                        .clip(shape = RectangleShape)
                        .clickable {
                            if (!gameViewModel.boxGClicked) {
                                gameViewModel.checkLetter("G") { newColor ->
                                    gameViewModel.boxGBackgroundColor = newColor
                                    gameViewModel.boxGClicked = true
                                }
                            }
                        }
                        .background(gameViewModel.boxGBackgroundColor)
                ) {
                    Text(
                        text = "G",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .padding(3.dp)
                        .clip(shape = RectangleShape)
                        .clickable {
                            if (!gameViewModel.boxHClicked) {
                                gameViewModel.checkLetter("H") { newColor ->
                                    gameViewModel.boxHBackgroundColor = newColor
                                    gameViewModel.boxHClicked = true
                                }
                            }
                        }
                        .background(gameViewModel.boxHBackgroundColor)
                ) {
                    Text(
                        text = "H",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .padding(3.dp)
                        .clip(shape = RectangleShape)
                        .clickable {
                            if (!gameViewModel.boxJClicked) {
                                gameViewModel.checkLetter("J") { newColor ->
                                    gameViewModel.boxJBackgroundColor = newColor
                                    gameViewModel.boxJClicked = true
                                }
                            }
                        }
                        .background(gameViewModel.boxJBackgroundColor)
                ) {
                    Text(
                        text = "J",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .padding(3.dp)
                        .clip(shape = RectangleShape)
                        .clickable {
                            if (!gameViewModel.boxKClicked) {
                                gameViewModel.checkLetter("K") { newColor ->
                                    gameViewModel.boxKBackgroundColor = newColor
                                    gameViewModel.boxKClicked = true
                                }
                            }
                        }
                        .background(gameViewModel.boxKBackgroundColor)
                ) {
                    Text(
                        text = "K",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .padding(3.dp)
                        .clip(shape = RectangleShape)
                        .clickable {
                            if (!gameViewModel.boxLClicked) {
                                gameViewModel.checkLetter("L") { newColor ->
                                    gameViewModel.boxLBackgroundColor = newColor
                                    gameViewModel.boxLClicked = true
                                }
                            }
                        }
                        .background(gameViewModel.boxLBackgroundColor)
                ) {
                    Text(
                        text = "L",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .padding(3.dp)
                        .clip(shape = RectangleShape)
                        .clickable {
                            if (!gameViewModel.boxÇClicked) {
                                gameViewModel.checkLetter("Ç") { newColor ->
                                    gameViewModel.boxÇBackgroundColor = newColor
                                    gameViewModel.boxÇClicked = true
                                }
                            }
                        }
                        .background(gameViewModel.boxÇBackgroundColor)
                ) {
                    Text(
                        text = "Ç",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }
            }

            // Linha 3 de letras Z-X-V-B-N-M
            Row {
                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .padding(3.dp)
                        .clip(shape = RectangleShape)
                        .clickable {
                            if (!gameViewModel.boxZClicked) {
                                gameViewModel.checkLetter("Z") { newColor ->
                                    gameViewModel.boxZBackgroundColor = newColor
                                    gameViewModel.boxZClicked = true
                                }
                            }
                        }
                        .background(gameViewModel.boxZBackgroundColor)
                ) {
                    Text(
                        text = "Z",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .padding(3.dp)
                        .clip(shape = RectangleShape)
                        .clickable {
                            if (!gameViewModel.boxXClicked) {
                                gameViewModel.checkLetter("X") { newColor ->
                                    gameViewModel.boxXBackgroundColor = newColor
                                    gameViewModel.boxXClicked = true
                                }
                            }
                        }
                        .background(gameViewModel.boxXBackgroundColor)
                ) {
                    Text(
                        text = "X",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .padding(3.dp)
                        .clip(shape = RectangleShape)
                        .clickable {
                            if (!gameViewModel.boxCClicked) {
                                gameViewModel.checkLetter("C") { newColor ->
                                    gameViewModel.boxCBackgroundColor = newColor
                                    gameViewModel.boxCClicked = true
                                }
                            }
                        }
                        .background(gameViewModel.boxCBackgroundColor)
                ) {
                    Text(
                        text = "C",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .padding(3.dp)
                        .clip(shape = RectangleShape)
                        .clickable {
                            if (!gameViewModel.boxVClicked) {
                                gameViewModel.checkLetter("V") { newColor ->
                                    gameViewModel.boxVBackgroundColor = newColor
                                    gameViewModel.boxVClicked = true
                                }
                            }
                        }
                        .background(gameViewModel.boxVBackgroundColor)
                ) {
                    Text(
                        text = "V",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .padding(3.dp)
                        .clip(shape = RectangleShape)
                        .clickable {
                            if (!gameViewModel.boxBClicked) {
                                gameViewModel.checkLetter("B") { newColor ->
                                    gameViewModel.boxBBackgroundColor = newColor
                                    gameViewModel.boxBClicked = true
                                }
                            }
                        }
                        .background(gameViewModel.boxBBackgroundColor)
                ) {
                    Text(
                        text = "B",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .padding(3.dp)
                        .clip(shape = RectangleShape)
                        .clickable {
                            if (!gameViewModel.boxNClicked) {
                                gameViewModel.checkLetter("N") { newColor ->
                                    gameViewModel.boxNBackgroundColor = newColor
                                    gameViewModel.boxNClicked = true
                                }
                            }
                        }
                        .background(gameViewModel.boxNBackgroundColor)
                ) {
                    Text(
                        text = "N",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .padding(3.dp)
                        .clip(shape = RectangleShape)
                        .clickable {
                            if (!gameViewModel.boxMClicked) {
                                gameViewModel.checkLetter("M") { newColor ->
                                    gameViewModel.boxMBackgroundColor = newColor
                                    gameViewModel.boxMClicked = true
                                }
                            }
                        }
                        .background(gameViewModel.boxMBackgroundColor)
                ) {
                    Text(
                        text = "M",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {

    val gameViewModel = remember {
        GameViewModel(allWords.toSet()) // Converte o conjunto para uma lista
    }

    JogoDaForcaTheme {
        GameLayoutScreen(gameViewModel = gameViewModel)
    }
}
