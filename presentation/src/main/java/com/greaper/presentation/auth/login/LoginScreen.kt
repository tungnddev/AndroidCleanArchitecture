package com.greaper.presentation.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavHostController
import com.greaper.presentation.R
import kotlinx.coroutines.delay
import java.util.logging.Handler
import kotlin.time.seconds

@Composable
fun LoginScreen(navController: NavHostController) {
    HelloScreen()
}

@Preview
@Composable
fun HelloScreen() {
    var loginValue by rememberSaveable  { mutableStateOf("") }
    var passwordValue by rememberSaveable { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(content = {
        Column(
            Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxHeight(0.5f)
                        .fillMaxWidth(),
                    contentScale = ContentScale.FillHeight
                )
//                Box(
//                    modifier = Modifier
//                        .fillMaxHeight(0.5f)
//                        .aspectRatio(1f)
//                        .background(Color.Black),
//                )
            }

            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                OutlinedTextField(
                    value = loginValue,
                    onValueChange = { value -> loginValue = value },
                    label = { Text("Email") },
                    modifier = Modifier
                        .fillMaxWidth(),
                    textStyle = MaterialTheme.typography.body1,
                )

                Spacer(modifier = Modifier.height(15.dp))

                OutlinedTextField(
                    value = passwordValue,
                    onValueChange = { value -> passwordValue = value },
                    label = { Text("Password") },
                    modifier = Modifier
                        .fillMaxWidth(),
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    textStyle = MaterialTheme.typography.body1,
                )

                Spacer(modifier = Modifier.height(40.dp))

                Button(
                    onClick = {
                              showDialog = true
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentPadding = PaddingValues(vertical = 14.dp)
                ) {
                    Text(text = "Login", style = MaterialTheme.typography.button)
                }

                Spacer(modifier = Modifier.height(30.dp))
            }

        }
        if (showDialog) {
            Dialog(
                onDismissRequest = { showDialog = false },
                DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
            ) {
                Box(
                    contentAlignment= Center,
                    modifier = Modifier
                        .size(100.dp)
                        .background(White, shape = RoundedCornerShape(8.dp))
                ) {
                    CircularProgressIndicator()
                }
            }
        }
        LaunchedEffect(showDialog) {
            delay(4000L)
            showDialog = false
        }
    })

//    HelloContent(name = name, onNameChange = { name = it })
}

@Composable
fun HelloContent(name: String, onNameChange: (String) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Hello, $name",
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.h5
        )
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Name") }
        )
    }
}