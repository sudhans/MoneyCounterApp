package com.msd.samples.moneycounterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.msd.samples.moneycounterapp.ui.theme.MoneyCounterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoneyCounterAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.onPrimaryContainer,

                ) {
                    MainApp()
                }
            }
        }
    }
}

@Composable
fun MainApp(modifier: Modifier = Modifier) {
    var counter by remember {
        mutableIntStateOf(100)
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = modifier.padding(32.dp),
            text = "$$counter",
            style = TextStyle(color = Color.White, fontWeight = FontWeight.Bold, fontSize = 32.sp),
        )
        Spacer(modifier = Modifier.height(32.dp))
        TapView {
            counter++
        }
    }
}

@Composable
fun TapView(updateCounter: () -> Unit) {
    Card(modifier = Modifier.size(120.dp).clickable { updateCounter() }.shadow(elevation = 4.dp), shape = CircleShape) {
        Text(
            modifier = Modifier.background(Color.White)
                .fillMaxSize().wrapContentSize(align = Alignment.Center),
            text = "Tap",
            style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 16.sp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainAppPreview() {
    MoneyCounterAppTheme {
        MainApp()
    }
}
