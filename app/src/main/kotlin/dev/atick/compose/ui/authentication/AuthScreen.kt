package dev.atick.compose.ui.authentication

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.atick.compose.R
import dev.atick.compose.ui.common.components.InputField

@Composable
fun AuthScreen(
    modifier: Modifier,
    viewModel: AuthViewModel = viewModel()
) {
    var newUser by remember { mutableStateOf(false) }

    return Box(modifier = Modifier.fillMaxSize().then(modifier)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.surface)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.width(160.dp),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "ErthaSys Logo"
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                text = if (newUser) "Sign Up" else "Login",
                color = MaterialTheme.colors.onSurface,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))

            AnimatedVisibility(visible = newUser) {
                InputField(
                    modifier = Modifier.fillMaxWidth(),
                    value = viewModel.name.value,
                    labelResourceId = R.string.full_name,
                    leadingIcon = Icons.Filled.Person,
                    onValueChange = {
                        viewModel.username.value = it
                    }
                )
            }

            InputField(
                modifier = Modifier.fillMaxWidth(),
                value = viewModel.username.value,
                labelResourceId = R.string.username,
                leadingIcon = Icons.Filled.Email,
                onValueChange = {
                    viewModel.username.value = it
                }
            )

            InputField(
                modifier = Modifier.fillMaxWidth(),
                value = viewModel.password.value,
                isPasswordField = true,
                labelResourceId = R.string.password,
                leadingIcon = Icons.Filled.Password,
                onValueChange = {
                    viewModel.password.value = it
                }
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = {
                    viewModel.login()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(text = if (newUser) stringResource(R.string.sign_up) else
                    stringResource(R.string.login))
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedButton(
                onClick = { newUser = !newUser },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(text = if (newUser) stringResource(R.string.login) else
                    stringResource(R.string.sign_up))
            }
            Spacer(modifier = Modifier.fillMaxHeight(0.3F))
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.width(24.dp),
                painter = painterResource(id = R.drawable.leveor),
                contentDescription = "ErthaSys Logo"
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Leveor.xyz",
                color = if (isSystemInDarkTheme()) Color.LightGray else Color.DarkGray,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}