package com.example.home.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.home.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SavedItemsList(modifier: Modifier = Modifier) {
    ElevatedCard(
        modifier = modifier.fillMaxWidth().padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = .5.dp)
    ) {
        Column(Modifier.background(colorResource(id = R.color.white))) {
            SavedItem(R.string.title_1, R.string.number_, R.string.berlin, R.string.paris)
            SavedItem(R.string.title_2, R.string.number_, R.string.lagos, R.string.paris)
            SavedItem(R.string.title_3, R.string.number_, R.string.abuja, R.string.rome)
            SavedItem(R.string.title_4, R.string.number_, R.string.paris, R.string.berlin)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SavedItem(@StringRes title: Int = R.string.title_1,
                      @StringRes number: Int = R.string.number,
                      @StringRes startCity: Int = R.string.berlin,
                      @StringRes destinationCity: Int = R.string.rome
) {
    Row(Modifier.padding(16.dp)) {
        Box(
            Modifier
                .clip(CircleShape)
                .background(colorResource(id = R.color.light_blue))
                .size(48.dp)
                .padding(16.dp)) {
            Image(painter = painterResource(id = R.drawable.box), contentDescription = "")
        }

        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                color = colorResource(id = R.color.black),
                style = MaterialTheme.typography.bodyMedium,
                text = stringResource(id = title))

            Spacer(modifier = Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    color = colorResource(id = R.color.brown),
                    style = MaterialTheme.typography.bodyMedium,
                    text = stringResource(id = number))

                Spacer(modifier = Modifier.width(8.dp))
                Box(
                    Modifier
                        .size(4.dp)
                        .clip(CircleShape)
                        .background(colorResource(id = R.color.default_ash)))
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    color = colorResource(id = R.color.brown),
                    style = MaterialTheme.typography.bodyMedium,
                    text = stringResource(id = startCity))

                Spacer(modifier = Modifier.height(8.dp))
                Image(painter = painterResource(id = R.drawable.long_arrow), contentDescription = "")

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    color = colorResource(id = R.color.brown),
                    style = MaterialTheme.typography.bodyMedium,
                    text = stringResource(id = destinationCity))
            }

            Spacer(modifier = Modifier.height(16.dp))
            Divider(
                color = colorResource(id = R.color.light_brown),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(.5.dp)
            )
        }
    }
}
