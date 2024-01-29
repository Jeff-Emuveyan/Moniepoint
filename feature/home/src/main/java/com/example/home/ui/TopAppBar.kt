package com.example.home.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.home.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TopAppBar(modifier: Modifier = Modifier, onReadyToSearch:(Boolean) -> Unit = {}) {
    Box(modifier = modifier.wrapContentSize()) {
        Column(
            modifier = Modifier
                .background(colorResource(id = R.color.light_blue))
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            UserInfoSection()
            Spacer(Modifier.height(20.dp))
            SearchSection(onReadyToSearch)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun UserInfoSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(48.dp),
                painter = painterResource(id = R.drawable.images),
                contentDescription = ""
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(Modifier.size(4.dp).clip(CircleShape).background(Color.White))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        style = MaterialTheme.typography.bodyMedium,
                        text = stringResource(id = R.string.your_location),
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row {
                    Text(
                        style = MaterialTheme.typography.bodyMedium,
                        text = stringResource(id = R.string.your_location_address),
                        color = Color.White
                    )
                    Image(
                        painter = painterResource(id = R.drawable.white_down_arrow),
                        contentDescription = ""
                    )
                }
            }
        }

        Image(
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .clip(CircleShape)
                .background(Color.White)
                .size(48.dp)
                .padding(8.dp),
            painter = painterResource(id = R.drawable.notifications),
            contentDescription = ""
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SearchSection(onReadyToSearch:(Boolean) -> Unit = {}) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(50.dp))
            .background(colorResource(id = R.color.very_light_brown))
            .fillMaxWidth()
            .padding(start = 16.dp, top = 6.dp, bottom = 6.dp, end = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row {
            Image(
                modifier = Modifier.size(16.dp),
                painter = painterResource(R.drawable.magnifying),
                contentDescription = ""
            )

            Spacer(Modifier.width(16.dp))

            val text = remember { mutableStateOf("") }
            BasicTextField(
                modifier = Modifier.focusRequester(FocusRequester.Default)
                    .onFocusChanged {  onReadyToSearch(it.isFocused)  },
                value = text.value,
                onValueChange = {
                    text.value = it
                },
                decorationBox = { innerTextField ->
                    Box {
                        if (text.value.isEmpty()) {
                            Text(
                                text = stringResource(R.string.search_text),
                                color = colorResource(id = R.color.brown),
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                        innerTextField()
                    }
                }
            )
        }

        Image(
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .clip(CircleShape)
                .background(colorResource(id = R.color.orange))
                .size(32.dp)
                .padding(6.dp),
            painter = painterResource(id = R.drawable.card),
            contentDescription = ""
        )
    }
}