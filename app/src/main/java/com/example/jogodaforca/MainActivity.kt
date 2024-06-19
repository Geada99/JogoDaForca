package com.example.jogodaforca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jogodaforca.ui.theme.JogoDaForcaTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JogoDaForcaTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = "home") {
                        composable("home") { GameScreen(navController) }
                        composable("game") {
                            val gameViewModelFactory = GameViewModelFactory(allWords.toSet())
                            val gameViewModel: GameViewModel = viewModel(factory = gameViewModelFactory)
                            GameLayoutScreen(gameViewModel = gameViewModel)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun GameScreen(navController: NavController) {
    val mediumPadding = dimensionResource(R.dimen.padding_medium)

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding()
            .padding(mediumPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.titleLarge,
            fontSize = 35.sp
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(mediumPadding),
            verticalArrangement = Arrangement.spacedBy(mediumPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navController.navigate("game")
                }
            ) {
                Text(
                    text = stringResource(R.string.play),
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun GameLayoutScreen(gameViewModel: GameViewModel) {
    val mediumPadding = dimensionResource(R.dimen.padding_medium)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(mediumPadding),
        verticalArrangement = Arrangement.spacedBy(mediumPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GameLayout(gameViewModel = gameViewModel)
    }
}

@Composable
fun GameLayout(modifier: Modifier = Modifier, gameViewModel: GameViewModel) {
    val mediumPadding = dimensionResource(R.dimen.padding_medium)

    val hiddenWord by gameViewModel.hiddenWord.collectAsState()

    // Carregar o Array do ficheiro arrays.xml
    val imageArray = stringArrayResource(R.array.image_array)

    // Código milagroso do ChatGPT visto que .toInt() não funciona num array
    val imageResourceId = imageArray.getOrNull(0)?.toIntOrNull() ?: R.drawable.hangman_picture_1

    // Escolha da imagem apresentada
    val imagemForca = painterResource(id = imageResourceId)
    Column(
        verticalArrangement = Arrangement.spacedBy(mediumPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(mediumPadding)
            .size(450.dp)
    ) {
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.titleLarge,
            fontSize = 35.sp
        )
        Image(
            modifier = Modifier
                .size(250.dp)
                .padding(mediumPadding*2),
            painter = imagemForca,
            contentDescription = "Forca"
        )
        Text(
            fontSize = 30.sp,
            text = hiddenWord
        )
    }
    Column(
        modifier = Modifier,
        //.fillMaxSize(),
        verticalArrangement = Arrangement.Center,  // Alinha os elementos verticalmente ao centro
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
            Row{
                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .padding(3.dp)
                        .clip(shape = RectangleShape)
                        .clickable { /* Ação do clique */ }
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
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
                        .clickable { /* Ação do clique */ }
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
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
                        .clickable { /* Ação do clique */ }
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
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
                        .clickable { /* Ação do clique */ }
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
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
                        .clickable { /* Ação do clique */ }
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
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
                        .clickable { /* Ação do clique */ }
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
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
                        .clickable { /* Ação do clique */ }
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
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
                        .clickable { /* Ação do clique */ }
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
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
                        .clickable { /* Ação do clique */ }
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
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
                        .clickable { /* Ação do clique */ }
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "P",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }
            }


            Row {
                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .padding(3.dp)
                        .clip(shape = RectangleShape)
                        .clickable { /* Ação do clique */ }
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
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
                        .clickable { /* Ação do clique */ }
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
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
                        .clickable { /* Ação do clique */ }
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
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
                        .clickable { /* Ação do clique */ }
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
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
                        .clickable { /* Ação do clique */ }
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
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
                        .clickable { /* Ação do clique */ }
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
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
                        .clickable { /* Ação do clique */ }
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
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
                        .clickable { /* Ação do clique */ }
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
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
                        .clickable { /* Ação do clique */ }
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
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
                        .clickable { /* Ação do clique */ }
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Ç",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }
            }


            Row {
                Box(
                    modifier = Modifier
                        .size(33.dp)
                        .padding(3.dp)
                        .clip(shape = RectangleShape)
                        .clickable { /* Ação do clique */ }
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
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
                        .clickable { /* Ação do clique */ }
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
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
                        .clickable { /* Ação do clique */ }
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
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
                        .clickable { /* Ação do clique */ }
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
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
                        .clickable { /* Ação do clique */ }
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
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
                        .clickable { /* Ação do clique */ }
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
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
                        .clickable { /* Ação do clique */ }
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
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



@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    JogoDaForcaTheme {
        GameLayoutScreen(GameViewModel(allWords))
    }
}
