package com.example.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.home.R
import com.example.home.ui.BottomAppBar

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen(showSearchResultsOnly: Boolean = false,
               onMenuItemClicked: (String) -> Unit = {},
               onReadyToSearch:(Boolean) -> Unit = {}) {

    if (!showSearchResultsOnly) {
        LocalFocusManager.current.clearFocus(true)
    }

    ConstraintLayout {
        val (topAppBar, middle, bottomAppBar) = createRefs()

        val topModifier = Modifier.constrainAs(topAppBar) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        val middleModifier = Modifier.constrainAs(middle) {
            top.linkTo(topAppBar.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        val bottomModifier = Modifier.constrainAs(bottomAppBar) {
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        TopAppBar(topModifier, showSearchResultsOnly, onReadyToSearch)
        if (showSearchResultsOnly) {
            SavedItemsList(middleModifier)
        } else {
            MainContent(middleModifier)
            BottomAppBar(bottomModifier, onMenuItemClicked)
        }
    }
}
