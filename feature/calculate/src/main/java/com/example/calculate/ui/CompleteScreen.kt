package com.example.calculate.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculate.R
import com.example.calculate.bounceClick

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CompleteScreen(onClick: () -> Unit = {}) {

    Box(
        Modifier
            .padding(16.dp)
            .fillMaxSize(), contentAlignment = Alignment.Center) {
        Content(onClick)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Content(onClick: () -> Unit = {}) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            modifier = Modifier
                .size(200.dp, 60.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Image(
            painter = painterResource(id = R.drawable.box),
            contentDescription = "",
            modifier = Modifier
                .size(100.dp, 100.dp)
                .fillMaxWidth()
        )

        Spacer(Modifier.height(24.dp))

        Text(
            text = stringResource(id = R.string.total),
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.Bottom) {
            Text(
                text = "$145",
                style = MaterialTheme.typography.titleLarge,
                color = colorResource(id = R.color.light_green)
            )
            Text(
                text = "USD",
                color = colorResource(id = R.color.light_green)
            )
        }

        Spacer(Modifier.height(8.dp))

        Text(
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.this_amount),
            color = colorResource(id = R.color.light_brown),
            lineHeight = 16.sp
        )

        Spacer(Modifier.height(24.dp))

        BackButton(onClick)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun BackButton(onClick: () -> Unit = {}) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .bounceClick(onClick),
        contentPadding = PaddingValues(all = 14.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange)),
    ) {
        Text(
            text = stringResource(id = R.string.back_home),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
