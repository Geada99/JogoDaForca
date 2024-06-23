package com.example.jogodaforca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.Composable


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GameScreen()
}

// Página Inicial
@Composable
fun HangmanApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hangman Game",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        GameScreen()
    }
}

// Ecrã de jogo
@Composable
fun GameScreen() {
    val gameViewModel: GameViewModel = viewModel()

    val mediumPadding = dimensionResource(R.dimen.padding_medium)

    val imagemForca = remember { mutableIntStateOf(gameViewModel.getCurrentImageResource()) }

    // gameViewModel recebido é usado como parâmetro para acessar o estado
    val hiddenWord by gameViewModel.hiddenWord.collectAsState()

    Column(
        verticalArrangement = Arrangement.spacedBy(mediumPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(mediumPadding)
            .fillMaxSize()
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
            painter = painterResource(id = gameViewModel.getCurrentImageResource()),
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
                    modifier = Modifier.align(Alignment.Center),
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
                                imagemForca.intValue = gameViewModel.getCurrentImageResource()
                            }
                        }
                    }
                    .background(gameViewModel.boxWBackgroundColor)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
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
                                imagemForca.intValue = gameViewModel.getCurrentImageResource()
                            }
                        }
                    }
                    .background(gameViewModel.boxEBackgroundColor)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
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
                                imagemForca.intValue = gameViewModel.getCurrentImageResource()
                            }
                        }
                    }
                    .background(gameViewModel.boxRBackgroundColor)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
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
                                imagemForca.intValue = gameViewModel.getCurrentImageResource()
                            }
                        }
                    }
                    .background(gameViewModel.boxTBackgroundColor)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
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
                                imagemForca.intValue = gameViewModel.getCurrentImageResource()
                            }
                        }
                    }
                    .background(gameViewModel.boxYBackgroundColor)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
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
                                imagemForca.intValue = gameViewModel.getCurrentImageResource()
                            }
                        }
                    }
                    .background(gameViewModel.boxUBackgroundColor)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
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
                                imagemForca.intValue = gameViewModel.getCurrentImageResource()
                            }
                        }
                    }
                    .background(gameViewModel.boxIBackgroundColor)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
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
                                imagemForca.intValue = gameViewModel.getCurrentImageResource()
                            }
                        }
                    }
                    .background(gameViewModel.boxOBackgroundColor)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
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
                                imagemForca.intValue = gameViewModel.getCurrentImageResource()
                            }
                        }
                    }
                    .background(gameViewModel.boxPBackgroundColor)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
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
                                imagemForca.intValue = gameViewModel.getCurrentImageResource()
                            }
                        }
                    }
                    .background(gameViewModel.boxABackgroundColor)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
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
                                imagemForca.intValue = gameViewModel.getCurrentImageResource()
                            }
                        }
                    }
                    .background(gameViewModel.boxSBackgroundColor)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
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
                                imagemForca.intValue = gameViewModel.getCurrentImageResource()
                            }
                        }
                    }
                    .background(gameViewModel.boxDBackgroundColor)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
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
                                imagemForca.intValue = gameViewModel.getCurrentImageResource()
                            }
                        }
                    }
                    .background(gameViewModel.boxFBackgroundColor)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
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
                                imagemForca.intValue = gameViewModel.getCurrentImageResource()
                            }
                        }
                    }
                    .background(gameViewModel.boxGBackgroundColor)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
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
                                imagemForca.intValue = gameViewModel.getCurrentImageResource()
                            }
                        }
                    }
                    .background(gameViewModel.boxHBackgroundColor)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
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
                                imagemForca.intValue = gameViewModel.getCurrentImageResource()
                            }
                        }
                    }
                    .background(gameViewModel.boxJBackgroundColor)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
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
                                imagemForca.intValue = gameViewModel.getCurrentImageResource()
                            }
                        }
                    }
                    .background(gameViewModel.boxKBackgroundColor)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
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
                                imagemForca.intValue = gameViewModel.getCurrentImageResource()
                            }
                        }
                    }
                    .background(gameViewModel.boxLBackgroundColor)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
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
                        if (!gameViewModel.boxCedilhaClicked) {
                            gameViewModel.checkLetter("Ç") { newColor ->
                                gameViewModel.boxCedilhaBackgroundColor = newColor
                                gameViewModel.boxCedilhaClicked = true
                                imagemForca.intValue = gameViewModel.getCurrentImageResource()
                            }
                        }
                    }
                    .background(gameViewModel.boxCedilhaBackgroundColor)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "Ç",
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
        }

        // Linha 3 de letras Z-X-C-V-B-N-M
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
                                imagemForca.intValue = gameViewModel.getCurrentImageResource()
                            }
                        }
                    }
                    .background(gameViewModel.boxZBackgroundColor)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
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
                                imagemForca.intValue = gameViewModel.getCurrentImageResource()
                            }
                        }
                    }
                    .background(gameViewModel.boxXBackgroundColor)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
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
                                imagemForca.intValue = gameViewModel.getCurrentImageResource()
                            }
                        }
                    }
                    .background(gameViewModel.boxCBackgroundColor)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
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
                                imagemForca.intValue = gameViewModel.getCurrentImageResource()
                            }
                        }
                    }
                    .background(gameViewModel.boxVBackgroundColor)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
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
                                imagemForca.intValue = gameViewModel.getCurrentImageResource()
                            }
                        }
                    }
                    .background(gameViewModel.boxBBackgroundColor)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
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
                                imagemForca.intValue = gameViewModel.getCurrentImageResource()
                            }
                        }
                    }
                    .background(gameViewModel.boxNBackgroundColor)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
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
                                imagemForca.intValue = gameViewModel.getCurrentImageResource()
                            }
                        }
                    }
                    .background(gameViewModel.boxMBackgroundColor)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "M",
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
        }
    }
}

