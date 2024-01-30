package com.example.shipment.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shipment.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ContentSection(modifier: Modifier = Modifier) {
    var showAnimations by remember { mutableStateOf(false) }

    SideEffect {
        showAnimations = true
    }

    // Animation: Slide upwards vertically
    AnimatedVisibility(
        visible = showAnimations,
        modifier = modifier,
        enter = slideInVertically (initialOffsetY = { it },
            animationSpec = tween(durationMillis = 300, easing = LinearEasing)
        )
    ) {
        Column(modifier.padding(16.dp).verticalScroll(rememberScrollState())) {
            Text(
                text = stringResource(id = R.string.shipments),
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(Modifier.height(16.dp))
            CardItem()
            Spacer(Modifier.height(16.dp))
            CardItem()
            Spacer(Modifier.height(16.dp))
            CardItem()
            Spacer(Modifier.height(16.dp))
            CardItem()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CardItem() {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = .5.dp)
    ) {

        Column(
            Modifier
                .background(colorResource(id = R.color.white))
                .fillMaxWidth()
                .padding(16.dp)) {

            StatusIcon()
            Spacer(Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column {
                    Text(
                        style = MaterialTheme.typography.titleMedium,
                        text = stringResource(id = R.string.arriving_today)
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        lineHeight = 16.sp,
                        color = colorResource(id = R.color.brown),
                        style = MaterialTheme.typography.bodyMedium,
                        text = stringResource(id = R.string.message)
                    )
                    Spacer(Modifier.height(10.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.light_blue),
                            text = stringResource(id = R.string.dollar)
                        )
                        Spacer(Modifier.width(8.dp))
                        Box(
                            Modifier
                                .size(4.dp)
                                .clip(CircleShape)
                                .background(colorResource(id = R.color.brown))
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            style = MaterialTheme.typography.bodyMedium,
                            text = stringResource(id = R.string.date)
                        )
                    }
                }
                Image(
                    modifier = Modifier.size(48.dp, 48.dp),
                    painter = painterResource(id = R.drawable.restore_two),
                    contentDescription = ""
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun StatusIcon() {
    Row(
        Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(colorResource(id = R.color.off_white))
            .padding(horizontal = 8.dp, vertical = 4.dp)) {
        Image(painter = painterResource(id = R.drawable.restore), contentDescription = "")
        Spacer(Modifier.width(8.dp))
        Text(
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.orange_dark),
            text = stringResource(id = R.string._pending)
        )
    }
}