package com.example.pizza_pro_2.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pizza_pro_2.R
import com.example.pizza_pro_2.component.ActionButton
import com.example.pizza_pro_2.component.AuthTextField
import com.example.pizza_pro_2.component.DefaultColumn
import com.example.pizza_pro_2.component.FooterText
import com.example.pizza_pro_2.component.HeaderText
import com.example.pizza_pro_2.database.entity.User
import com.example.pizza_pro_2.navigation.HOME_GRAPH_ROUTE
import com.example.pizza_pro_2.navigation.Screen
import com.example.pizza_pro_2.option.Gender
import com.example.pizza_pro_2.ui.theme.Pizza_Pro_2_Theme
import kotlinx.coroutines.runBlocking

@Composable
fun SignUpScreen(navController: NavController) {
    val (name, setName) = rememberSaveable { mutableStateOf("") }
    val (email, setEmail) = rememberSaveable { mutableStateOf("") }
    val (password, setPassword) = rememberSaveable { mutableStateOf("") }
    val (location, setLocation) = rememberSaveable { mutableStateOf("") }

    DefaultColumn {
        HeaderText(text = stringResource(id = R.string.sign_up))

        Spacer(modifier = Modifier.height(20.dp))

        AuthTextField(
            value = name,
            onValueChange = setName,
            label = stringResource(id = R.string.name),
            leadingIcon = Icons.Default.Person
        )

        Spacer(modifier = Modifier.height(8.dp))

        AuthTextField(
            value = email,
            onValueChange = setEmail,
            label = stringResource(id = R.string.email),
            leadingIcon = Icons.Default.Email
        )

        Spacer(modifier = Modifier.height(8.dp))

        AuthTextField(
            value = password,
            onValueChange = setPassword,
            label = stringResource(id = R.string.password),
            leadingIcon = Icons.Default.Lock,
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(8.dp))

        AuthTextField(
            value = location,
            onValueChange = setLocation,
            label = stringResource(id = R.string.location),
            leadingIcon = Icons.Default.LocationOn
        )

        Spacer(modifier = Modifier.height(40.dp))

        ActionButton(
            text = stringResource(id = R.string.sign_up),
            onClick = {
                if (validateInput(name, email, password, location)) {
                    insertUserIntoDB(name, email, password, location)
                    navController.navigate(HOME_GRAPH_ROUTE) {
                        popUpTo(Screen.Intro.route) {
                            inclusive = true
                        }
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(40.dp))

        FooterText(
            text = stringResource(id = R.string.already_have_an_account),
            hyperText = stringResource(id = R.string.sign_in),
            onClick = {
                navController.navigate(Screen.SignIn.route) {
                    popUpTo(Screen.SignUp.route) {
                        inclusive = true
                    }
                    launchSingleTop = true
                }
            }
        )
    }
}

private fun insertUserIntoDB(
    name: String,
    email: String,
    password: String,
    location: String
) {
    val user = User(
        name = name,
        email = email,
        password = password,
        location = location,
        gender = Gender.MALE
    )
    runBlocking {

    }
}

private fun validateInput(
    name: String,
    email: String,
    password: String,
    location: String
): Boolean {
    return /*name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && location.isNotEmpty()*/ true
}

@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    Pizza_Pro_2_Theme {
        SignUpScreen(navController = rememberNavController())
    }
}
