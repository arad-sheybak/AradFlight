package com.aradsheybak.flightticket.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.aradsheybak.flightticket.R
import com.aradsheybak.flightticket.ui.components.BaseButton
import com.aradsheybak.flightticket.ui.components.BaseTextField
import com.aradsheybak.flightticket.ui.components.gradientBackground
import com.aradsheybak.flightticket.ui.navigation.Screen

@Composable
fun LoginScreen(navController: NavHostController) {
    Ui(navController)
}

@Composable
private fun Ui(navController: NavHostController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBackground())
    ) {
        val (boxTop,
            boxBottom) = createRefs()

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsPadding(WindowInsets.statusBars)
                .height(200.dp)
                .alpha(0.8f)
                .constrainAs(boxTop) {
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                }
        ) {
            Image(
                painter = painterResource(R.drawable.ic_logo),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .align(Alignment.TopCenter)


            )
            Image(
                painter = painterResource(R.drawable.ic_airplane),
                contentDescription = null,
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .align(Alignment.TopCenter)


            )
        }
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(boxBottom) {
                    top.linkTo(boxTop.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            val (usernameTitle,
                passwordTitle,
                usernameInput,
                passwordInput,
                loginBtn,
                createAccount) = createRefs()

            Text(
                text = stringResource(R.string.email),
                color = colorResource(R.color.white),
                fontSize = 20.sp,
                fontWeight = FontWeight.W400,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 16.dp)
                    .constrainAs(usernameTitle) {
                        top.linkTo(parent.top)
                    }
            )

            BaseTextField(
                modifier = Modifier.constrainAs(usernameInput) {
                    top.linkTo(usernameTitle.bottom)
                    start.linkTo(usernameTitle.start)
                },
                value = username,
                onValueChange = { username = it },
                placeholder = stringResource(R.string.email_placeholder),
                keyboardType = KeyboardType.Email,
                placeholderColor = colorResource(R.color.placeholder_color)
            )

            Text(
                text = stringResource(R.string.password),
                color = colorResource(R.color.white),
                fontSize = 20.sp,
                fontWeight = FontWeight.W400,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 16.dp)
                    .constrainAs(passwordTitle) {
                        top.linkTo(usernameInput.bottom)
                        start.linkTo(usernameTitle.start)
                    }
            )

            BaseTextField(
                modifier = Modifier.constrainAs(passwordInput) {
                    top.linkTo(passwordTitle.bottom)
                    start.linkTo(passwordTitle.start)
                },
                value = password,
                onValueChange = { password = it },
                placeholder = stringResource(R.string.password_placeholder),
                keyboardType = KeyboardType.Password,
                placeholderColor = colorResource(R.color.placeholder_color)
            )

            BaseButton(
                text = "Login",
                fontSize = 20.sp,
                backgroundColor = colorResource(R.color.blue_light),
                borderColor = colorResource(R.color.stroke_purple),
                borderWidth = 1.dp,
                onClick = {
                    navController.navigate(Screen.Main.route)
                },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(48.dp)
                    .constrainAs(loginBtn) {
                        top.linkTo(passwordInput.bottom, margin = 24.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })

            Text(
                text = stringResource(R.string.create_new_account),
                color = colorResource(R.color.white),
                fontSize = 16.sp,
                fontWeight = FontWeight.W300,
                modifier = Modifier
                    .clickable {
                        navController.navigate(Screen.Signup.route)
                    }
                    .constrainAs(createAccount) {
                        top.linkTo(loginBtn.bottom, margin = 28.dp)
                        start.linkTo(loginBtn.start)
                        end.linkTo(loginBtn.end)
                    },

                )

        }
    }
}
