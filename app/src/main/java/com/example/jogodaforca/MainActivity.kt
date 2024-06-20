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
import androidx.compose.runtime.*
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import com.example.jogodaforca.GameViewModelFactory
import com.example.jogodaforca.R
import com.example.jogodaforca.allWords

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JogoDaForcaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = "home") {
                        composable("home") { GameScreen(navController) }
                        composable("game") {
                            val gameViewModelFactory = GameViewModelFactory(allWords.toSet())
                            val gameViewModel: GameViewModel =
                                viewModel(factory = gameViewModelFactory)
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
            .background(
                color = Color.White
            ),

        verticalArrangement = Arrangement.spacedBy(mediumPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GameLayout(gameViewModel = gameViewModel)
    }
}

@Composable
fun GameLayout(modifier: Modifier = Modifier, gameViewModel: GameViewModel) {
    val mediumPadding = dimensionResource(R.dimen.padding_medium)

    // Estado para controlar se a caixa foi clicada e para escolher a cor de fundo da Box
    var boxQClicked by remember { mutableStateOf(false) }
    var boxQBackgroundColor by remember { mutableStateOf(Color.Gray) }

    var boxWClicked by remember { mutableStateOf(false) }
    var boxWBackgroundColor by remember { mutableStateOf(Color.Gray) }

    var boxEClicked by remember { mutableStateOf(false) }
    var boxEBackgroundColor by remember { mutableStateOf(Color.Gray) }

    var boxRClicked by remember { mutableStateOf(false) }
    var boxRBackgroundColor by remember { mutableStateOf(Color.Gray) }

    var boxTClicked by remember { mutableStateOf(false) }
    var boxTBackgroundColor by remember { mutableStateOf(Color.Gray) }

    var boxYClicked by remember { mutableStateOf(false) }
    var boxYBackgroundColor by remember { mutableStateOf(Color.Gray) }

    var boxUClicked by remember { mutableStateOf(false) }
    var boxUBackgroundColor by remember { mutableStateOf(Color.Gray) }

    var boxIClicked by remember { mutableStateOf(false) }
    var boxIBackgroundColor by remember { mutableStateOf(Color.Gray) }

    var boxOClicked by remember { mutableStateOf(false) }
    var boxOBackgroundColor by remember { mutableStateOf(Color.Gray) }

    var boxPClicked by remember { mutableStateOf(false) }
    var boxPBackgroundColor by remember { mutableStateOf(Color.Gray) }

    var boxAClicked by remember { mutableStateOf(false) }
    var boxABackgroundColor by remember { mutableStateOf(Color.Gray) }

    var boxSClicked by remember { mutableStateOf(false) }
    var boxSBackgroundColor by remember { mutableStateOf(Color.Gray) }

    var boxDClicked by remember { mutableStateOf(false) }
    var boxDBackgroundColor by remember { mutableStateOf(Color.Gray) }

    var boxFClicked by remember { mutableStateOf(false) }
    var boxFBackgroundColor by remember { mutableStateOf(Color.Gray) }

    var boxGClicked by remember { mutableStateOf(false) }
    var boxGBackgroundColor by remember { mutableStateOf(Color.Gray) }

    var boxHClicked by remember { mutableStateOf(false) }
    var boxHBackgroundColor by remember { mutableStateOf(Color.Gray) }

    var boxJClicked by remember { mutableStateOf(false) }
    var boxJBackgroundColor by remember { mutableStateOf(Color.Gray) }

    var boxKClicked by remember { mutableStateOf(false) }
    var boxKBackgroundColor by remember { mutableStateOf(Color.Gray) }

    var boxLClicked by remember { mutableStateOf(false) }
    var boxLBackgroundColor by remember { mutableStateOf(Color.Gray) }

    var boxCClicked by remember { mutableStateOf(false) }
    var boxCBackgroundColor by remember { mutableStateOf(Color.Gray) }

    var boxZClicked by remember { mutableStateOf(false) }
    var boxZBackgroundColor by remember { mutableStateOf(Color.Gray) }

    var boxXClicked by remember { mutableStateOf(false) }
    var boxXBackgroundColor by remember { mutableStateOf(Color.Gray) }

    var boxVClicked by remember { mutableStateOf(false) }
    var boxVBackgroundColor by remember { mutableStateOf(Color.Gray) }

    var boxBClicked by remember { mutableStateOf(false) }
    var boxBBackgroundColor by remember { mutableStateOf(Color.Gray) }

    var boxNClicked by remember { mutableStateOf(false) }
    var boxNBackgroundColor by remember { mutableStateOf(Color.Gray) }

    var boxMClicked by remember { mutableStateOf(false) }
    var boxMBackgroundColor by remember { mutableStateOf(Color.Gray) }

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
            .size(400.dp)
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

        // Renderiza as letras clicáveis em linhas
    }
    Column(
        modifier = Modifier,
        //.fillMaxSize(),
        verticalArrangement = Arrangement.Center,  // Alinha os elementos verticalmente ao centro
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Column(
                modifier = Modifier,
                //.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row {
                    Box(
                        modifier = Modifier
                            .size(33.dp)
                            .padding(3.dp)
                            .clip(shape = RectangleShape)
                            .clickable {
                                if (!boxQClicked) {
                                    gameViewModel.checkLetter("Q") { newColor ->
                                        boxQBackgroundColor = newColor
                                        boxQClicked = true
                                    }
                                }
                            }
                            .background(boxQBackgroundColor)
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
                                if (!boxWClicked) {
                                    gameViewModel.checkLetter("W") { newColor ->
                                        boxWBackgroundColor = newColor
                                        boxWClicked = true
                                    }
                                }
                            }
                            .background(boxWBackgroundColor)
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
                                if (!boxEClicked) {
                                    gameViewModel.checkLetter("E") { newColor ->
                                        boxEBackgroundColor = newColor
                                        boxEClicked = true
                                    }
                                }
                            }
                            .background(boxEBackgroundColor)
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
                                if (!boxRClicked) {
                                    gameViewModel.checkLetter("R") { newColor ->
                                        boxRBackgroundColor = newColor
                                        boxRClicked = true
                                    }
                                }
                            }
                            .background(boxRBackgroundColor)
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
                                if (!boxTClicked) {
                                    gameViewModel.checkLetter("T") { newColor ->
                                        boxTBackgroundColor = newColor
                                        boxTClicked = true
                                    }
                                }
                            }
                            .background(boxTBackgroundColor)
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
                                if (!boxYClicked) {
                                    gameViewModel.checkLetter("Y") { newColor ->
                                        boxYBackgroundColor = newColor
                                        boxYClicked = true
                                    }
                                }
                            }
                            .background(boxYBackgroundColor)
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
                                if (!boxUClicked) {
                                    gameViewModel.checkLetter("U") { newColor ->
                                        boxUBackgroundColor = newColor
                                        boxUClicked = true
                                    }
                                }
                            }
                            .background(boxUBackgroundColor)
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
                                if (!boxIClicked) {
                                    gameViewModel.checkLetter("I") { newColor ->
                                        boxIBackgroundColor = newColor
                                        boxIClicked = true
                                    }
                                }
                            }
                            .background(boxIBackgroundColor)
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
                                if (!boxOClicked) {
                                    gameViewModel.checkLetter("O") { newColor ->
                                        boxOBackgroundColor = newColor
                                        boxOClicked = true
                                    }
                                }
                            }
                            .background(boxOBackgroundColor)
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
                                if (!boxPClicked) {
                                    gameViewModel.checkLetter("P") { newColor ->
                                        boxPBackgroundColor = newColor
                                        boxPClicked = true
                                    }
                                }
                            }
                            .background(boxPBackgroundColor)
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
                            .clickable {
                                if (!boxAClicked) {
                                    gameViewModel.checkLetter("A") { newColor ->
                                        boxABackgroundColor = newColor
                                        boxAClicked = true
                                    }
                                }
                            }
                            .background(boxABackgroundColor)
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
                                if (!boxSClicked) {
                                    gameViewModel.checkLetter("S") { newColor ->
                                        boxSBackgroundColor = newColor
                                        boxSClicked = true
                                    }
                                }
                            }
                            .background(boxSBackgroundColor)
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
                                if (!boxDClicked) {
                                    gameViewModel.checkLetter("D") { newColor ->
                                        boxDBackgroundColor = newColor
                                        boxDClicked = true
                                    }
                                }
                            }
                            .background(boxDBackgroundColor)
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
                                if (!boxFClicked) {
                                    gameViewModel.checkLetter("F") { newColor ->
                                        boxFBackgroundColor = newColor
                                        boxFClicked = true
                                    }
                                }
                            }
                            .background(boxFBackgroundColor)
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
                                if (!boxGClicked) {
                                    gameViewModel.checkLetter("G") { newColor ->
                                        boxGBackgroundColor = newColor
                                        boxGClicked = true
                                    }
                                }
                            }
                            .background(boxGBackgroundColor)
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
                                if (!boxHClicked) {
                                    gameViewModel.checkLetter("H") { newColor ->
                                        boxHBackgroundColor = newColor
                                        boxHClicked = true
                                    }
                                }
                            }
                            .background(boxHBackgroundColor)
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
                                if (!boxJClicked) {
                                    gameViewModel.checkLetter("J") { newColor ->
                                        boxJBackgroundColor = newColor
                                        boxJClicked = true
                                    }
                                }
                            }
                            .background(boxJBackgroundColor)
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
                                if (!boxKClicked) {
                                    gameViewModel.checkLetter("K") { newColor ->
                                        boxKBackgroundColor = newColor
                                        boxKClicked = true
                                    }
                                }
                            }
                            .background(boxKBackgroundColor)
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
                                if (!boxLClicked) {
                                    gameViewModel.checkLetter("L") { newColor ->
                                        boxLBackgroundColor = newColor
                                        boxLClicked = true
                                    }
                                }
                            }
                            .background(boxLBackgroundColor)
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
                                if (!boxCClicked) {
                                    gameViewModel.checkLetter("Ç") { newColor ->
                                        boxCBackgroundColor = newColor
                                        boxCClicked = true
                                    }
                                }
                            }
                            .background(boxCBackgroundColor)
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
                            .clickable {
                                if (!boxZClicked) {
                                    gameViewModel.checkLetter("Z") { newColor ->
                                        boxZBackgroundColor = newColor
                                        boxZClicked = true
                                    }
                                }
                            }
                            .background(boxZBackgroundColor)
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
                                if (!boxXClicked) {
                                    gameViewModel.checkLetter("X") { newColor ->
                                        boxXBackgroundColor = newColor
                                        boxXClicked = true
                                    }
                                }
                            }
                            .background(boxXBackgroundColor)
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
                                if (!boxVClicked) {
                                    gameViewModel.checkLetter("V") { newColor ->
                                        boxVBackgroundColor = newColor
                                        boxVClicked = true
                                    }
                                }
                            }
                            .background(boxVBackgroundColor)
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
                                if (!boxBClicked) {
                                    gameViewModel.checkLetter("B") { newColor ->
                                        boxBBackgroundColor = newColor
                                        boxBClicked = true
                                    }
                                }
                            }
                            .background(boxBBackgroundColor)
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
                                if (!boxNClicked) {
                                    gameViewModel.checkLetter("N") { newColor ->
                                        boxNBackgroundColor = newColor
                                        boxNClicked = true
                                    }
                                }
                            }
                            .background(boxNBackgroundColor)
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
                                if (!boxMClicked) {
                                    gameViewModel.checkLetter("M") { newColor ->
                                        boxMBackgroundColor = newColor
                                        boxMClicked = true
                                    }
                                }
                            }
                            .background(boxMBackgroundColor)
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
}


        /*
        @Composable
        fun ClickableLetter(
            letter: String,
            gameViewModel: GameViewModel,
            onLetterClick: (Color) -> Unit
        ) {
            Box(
                modifier = Modifier
                    .size(33.dp)
                    .padding(3.dp)
                    .clip(shape = RectangleShape)
                    .clickable {
                        // Chama a função de verificação no ViewModel
                        gameViewModel.checkLetter(letter, onLetterClick)
                    }
                    .background(gameViewModel.getBoxBackgroundColor(letter)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = letter,
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
        }
    */

    @Preview(showBackground = true)
    @Composable
    fun GameScreenPreview() {
        JogoDaForcaTheme {
            GameLayoutScreen(GameViewModel(allWords))
        }
    }

