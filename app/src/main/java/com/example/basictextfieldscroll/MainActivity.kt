package com.example.basictextfieldscroll

import android.os.Bundle
import android.widget.EditText
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.basictextfieldscroll.ui.theme.BasicTextFieldScrollTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicTextFieldScrollTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(20.dp)
                            .padding(innerPadding)
                    ) {
                        Test("Try scrolling the below composable to the end") {
                            BasicTextField(
                                value = "Lorem ipsum dolor sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
                                onValueChange = {},
                                singleLine = true,
                            )
                        }

                        Spacer(Modifier.height(20.dp))

                        Test("Try scrolling the below EditText to the end") {
                            AndroidView(
                                factory = { context ->
                                    EditText(context).apply {
                                        setSingleLine()
                                        setText("Lorem ipsum dolor sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua")
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun Test(
        message: String,
        content: @Composable () -> Unit,
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .border(width = 3.dp, color = Color.Black)
                .padding(16.dp),
        ) {
            Text(message)

            Spacer(Modifier.height(30.dp))

            content()
        }
    }
}
