package com.borlanddev.cinamavibe.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borlanddev.cinamavibe.ui.theme.Caprasimo
import com.borlanddev.cinemavibe.R
import org.koin.androidx.compose.koinViewModel


@Composable // переписати на Hilt
fun LoginScreen(viewModel: LoginViewModel = koinViewModel()) {
    val loginState: LoginState by viewModel.state.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp)
    ) {
        Spacer(
            modifier = Modifier.padding(top = 50.dp)
        )
        Text(
            text = stringResource(id = R.string.login_title_text),
            fontSize = 24.sp,
            fontFamily = Caprasimo,
            color = MaterialTheme.colorScheme.primary,

            )
        Spacer(
            modifier = Modifier.height(150.dp)
        )

        LoginTextField(
            fieldText = loginState.email,
            labelText = stringResource(id = R.string.email_field_text),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            onValueChanged = viewModel::changeEmail
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )

        LoginTextField(
            fieldText = loginState.password,
            labelText = stringResource(id = R.string.password_field_text),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            onValueChanged = viewModel::changePassword
        )

        //LoginWithSocialNetwork()

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = viewModel::login,
            content = {
                Text(
                    stringResource(
                        id = if (!loginState.isRegistered) R.string.registration_button_text
                        else R.string.login_button_text
                    )
                )
            },
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
fun LoginTextField(
    modifier: Modifier = Modifier,
    fieldText: String,
    labelText: String,
    keyboardOptions: KeyboardOptions,
    onValueChanged: (String) -> Unit
) {
    OutlinedTextField(
        value = fieldText,
        label = { Text(labelText) },
        onValueChange = { onValueChanged(it) },
        singleLine = true,
        keyboardOptions = keyboardOptions,
        modifier = modifier.fillMaxWidth()

        /*  isError = isError,
                keyboardActions = KeyboardActions { validate(text) },
                modifier = Modifier.semantics {
                // Provide localized description of the error
                if (isError) error("Email format is invalid.")
            }*/
    )
}

@Composable
fun LoginWithSocialNetwork() {
    Row(
        modifier = Modifier
    ) {
        Card(
            modifier = Modifier
        ) {

        }
    }
}
