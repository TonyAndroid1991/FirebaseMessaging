package com.example.firebasemessaging

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.firebasemessaging.ui.theme.FireBaseMessagingTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SecondActivityText()
            Toast.makeText(this, "Second Activity", Toast.LENGTH_SHORT).show()
        }
    }

}


@Composable
fun SecondActivityText() {
    Text(modifier = Modifier.fillMaxSize(), text = "SecondActivityText")
}
