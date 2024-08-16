package com.example.dice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.dice.ui.theme.DiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DiceButtonAndImage()
                    Modifier.padding(innerPadding)
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DicePreview(){
    DiceTheme {
        DiceButtonAndImage()
    }
}

@Composable
fun DiceButtonAndImage(modifier: Modifier = Modifier){
    var result by remember { mutableIntStateOf(1) }
    val image = when(result){
        1->R.drawable.dice_1
        2->R.drawable.dice_2
        3->R.drawable.dice_3
        4->R.drawable.dice_4
        5->R.drawable.dice_5
        else->R.drawable.dice_6
    }
   Column(
       modifier = modifier.fillMaxSize(),
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally) {
       Image(painter = painterResource(image), contentDescription = "1")
       
       Button(onClick = { result = (1..6).random() }) {
           Text(
               stringResource(R.string.roll)
           )
           
       }


   }

}