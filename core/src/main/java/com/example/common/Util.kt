package com.example.common

fun getPositionToSlideTo(
    sliderWidth: Int,
    screenWidth: Int,
    positionOfMenuItem: Int
): Int {
    return when (positionOfMenuItem) {
        0 -> 0
        1 -> screenWidth / 4
        2 -> ( screenWidth / 4 ) * 2
        else -> screenWidth - sliderWidth // We do this subtraction because we don't want the slider
        // to go off screen.
    }
}