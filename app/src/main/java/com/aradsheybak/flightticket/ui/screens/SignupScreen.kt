package com.aradsheybak.flightticket.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.aradsheybak.flightticket.R
import com.aradsheybak.flightticket.ui.components.BaseButton
import com.aradsheybak.flightticket.ui.components.BaseTextField
import com.aradsheybak.flightticket.ui.components.gradientBackground

@Composable
fun SignupScreen() {
    Ui()
}

@Composable
@Preview
private fun Ui() {
    val scrollState = rememberScrollState()

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBackground())
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(bottom = 32.dp)
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
                    .background(gradientBackground())
            ) {
                val (content) = createRefs()

                val (
                    welcomeTitle,
                    firstnameTitle,
                    firstNameInput,
                    lastnameTitle,
                    lastNameInput,
                    emailTitle,
                    emailInput,
                    passwordTitle,
                    passwordInput,
                    confirmPasswordTitle,
                    confirmPasswordInput,
                    signupBtn) = createRefs()

                Text(
                    buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = colorResource(R.color.white),
                                fontSize = 32.sp,
                                fontWeight = FontWeight.W700
                            )
                        ) {
                            append(stringResource(R.string.welcome_signup))
                        }

                        append("\n")

                        withStyle(
                            style = SpanStyle(
                                color = colorResource(R.color.white),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.W300
                            )
                        ) {
                            append(stringResource(R.string.signup_form_title))
                        }
                    },
                    style = TextStyle(
                        lineHeight = 36.sp
                    ),
                    modifier = Modifier.constrainAs(welcomeTitle) {
                        top.linkTo(parent.top, margin = 48.dp)
                        start.linkTo(parent.start, margin = 16.dp)
                    }
                )

                Text(
                    text = stringResource(R.string.first_name),
                    color = colorResource(R.color.white),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.constrainAs(firstnameTitle) {
                        top.linkTo(welcomeTitle.bottom, margin = 16.dp)
                        start.linkTo(welcomeTitle.start)
                    })

                BaseTextField(
                    value = firstName,
                    onValueChange = { firstName = it },
                    placeholder = stringResource(R.string.first_name_placeholder),
                    placeholderColor = colorResource(R.color.placeholder_color),
                    modifier = Modifier
                        .constrainAs(firstNameInput) {
                            top.linkTo(firstnameTitle.bottom, margin = 8.dp)
                            start.linkTo(firstnameTitle.start)
                            end.linkTo(parent.end, margin = 16.dp)
                        }
                )

                Text(
                    text = stringResource(R.string.last_name),
                    color = colorResource(R.color.white),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.constrainAs(lastnameTitle) {
                        top.linkTo(firstNameInput.bottom, margin = 16.dp)
                        start.linkTo(firstnameTitle.start)
                    })

                BaseTextField(
                    value = lastName,
                    onValueChange = { lastName = it },
                    placeholder = stringResource(R.string.last_name_placeholder),
                    placeholderColor = colorResource(R.color.placeholder_color),
                    modifier = Modifier
                        .constrainAs(lastNameInput) {
                            top.linkTo(lastnameTitle.bottom, margin = 8.dp)
                            start.linkTo(lastnameTitle.start)
                            end.linkTo(parent.end, margin = 16.dp)
                        }
                )

                Text(
                    text = stringResource(R.string.email),
                    color = colorResource(R.color.white),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.constrainAs(emailTitle) {
                        top.linkTo(lastNameInput.bottom, margin = 16.dp)
                        start.linkTo(firstnameTitle.start)
                    })

                BaseTextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = stringResource(R.string.email_placeholder),
                    placeholderColor = colorResource(R.color.placeholder_color),
                    keyboardType = KeyboardType.Email,
                    modifier = Modifier
                        .constrainAs(emailInput) {
                            top.linkTo(emailTitle.bottom, margin = 8.dp)
                            start.linkTo(lastnameTitle.start)
                            end.linkTo(parent.end, margin = 16.dp)
                        }
                )

                Text(
                    text = stringResource(R.string.password),
                    color = colorResource(R.color.white),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.constrainAs(passwordTitle) {
                        top.linkTo(emailInput.bottom, margin = 16.dp)
                        start.linkTo(firstnameTitle.start)
                    })

                BaseTextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = stringResource(R.string.password_placeholder),
                    placeholderColor = colorResource(R.color.placeholder_color),
                    keyboardType = KeyboardType.Password,
                    modifier = Modifier
                        .constrainAs(passwordInput) {
                            top.linkTo(passwordTitle.bottom, margin = 8.dp)
                            start.linkTo(lastnameTitle.start)
                            end.linkTo(parent.end, margin = 16.dp)
                        }
                )

                Text(
                    text = stringResource(R.string.confirm_password),
                    color = colorResource(R.color.white),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.constrainAs(confirmPasswordTitle) {
                        top.linkTo(passwordInput.bottom, margin = 16.dp)
                        start.linkTo(firstnameTitle.start)
                    })

                BaseTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    placeholder = stringResource(R.string.confirm_password_placeholder),
                    placeholderColor = colorResource(R.color.placeholder_color),
                    keyboardType = KeyboardType.Password,
                    modifier = Modifier
                        .constrainAs(confirmPasswordInput) {
                            top.linkTo(confirmPasswordTitle.bottom, margin = 8.dp)
                            start.linkTo(lastnameTitle.start)
                            end.linkTo(parent.end, margin = 16.dp)
                        }
                )

                BaseButton(
                    text = stringResource(R.string.signup),
                    fontSize = 20.sp,
                    onClick = {},
                    backgroundColor = colorResource(R.color.base_color_purple),
                    borderColor = colorResource(R.color.stroke_purple),
                    borderWidth = 1.dp,
                    modifier = Modifier
                        .width(230.dp)
                        .height(48.dp)
                        .constrainAs(signupBtn) {
                            top.linkTo(confirmPasswordInput.bottom, margin = 16.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        })
            }
        }
    }


}
