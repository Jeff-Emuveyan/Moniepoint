package com.example.home.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.home.R

sealed class Screen(
    val route: String,
    @StringRes val title: Int,
    @DrawableRes val imageId: Int
) {
    data object Home : Screen(Route.HOME, R.string.home, com.example.home.R.drawable.home)
    data object Calculate : Screen(Route.CALCULATE, R.string.calculate, R.drawable.calculate)
    data object Complete : Screen(Route.COMPLETE, R.string.complete, 0)
    data object Shipment : Screen(Route.SHIPMENT, R.string.shipment, R.drawable.shipment)
    data object Profile: Screen("", R.string.profile, R.drawable.profile)
}