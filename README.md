# Moniepoint Translation Test

*Ensure you have the latest version of Android studio (Android Studio Hedgehog | 2023.1 preferrably) before cloning this repository.*

This is a parcel track delivery android app gotten from this design: https://dribbble.com/shots/21617837-Movemate-Shipments-Mobile-App

Animations in the design have been implemented.

<p float="left">
  <img src="https://firebasestorage.googleapis.com/v0/b/memo-24031.appspot.com/o/Screenshot_20240130_110237_Moniepoint.jpg?alt=media&token=ad74a2eb-d5d7-4c40-b98f-ac02b33a66da" width="300" height="650" />
  <img src="https://firebasestorage.googleapis.com/v0/b/memo-24031.appspot.com/o/Screenshot_20240130_110243_Moniepoint.jpg?alt=media&token=f0c240bd-a238-4237-869f-4ec220225cfe" width="300" height="650" />
 <img src="https://firebasestorage.googleapis.com/v0/b/memo-24031.appspot.com/o/Screenshot_20240130_110253_Moniepoint.jpg?alt=media&token=555cffef-f178-45a0-820a-57129ae883bc" width="300" height="650" />
</p>

The application is designed entirely in [Jetpack compose](https://developer.android.com/jetpack/compose).

## Dependencies

1) Jetpack Compose
2) Hilt
3) Navigation Compose

## Module Structure

I followed the **Google recommended** [modularization structure](https://developer.android.com/topic/modularization/patterns#types-of-modules),
and I grouped the code base into three main modules: 
1) ```app```: This is the container module of the application. Its sole duty is to display all features of the application
2) ```core```: The core module serves as the base module. It contains code that can be resued across any part of the code base.
3) ```feature```: The feature module contains all features of the application.

## Something extra! 😁😁

I added an automated UI test using [UiAutomator](https://developer.android.com/training/testing/other-components/ui-automator) to launch and verify that the
the expected Composables are visbile when the app is launched.
This automated test can be found here:
https://github.com/Jeff-Emuveyan/Moniepoint/blob/master/app/src/androidTest/java/com/example/moniepoint/AutomationTest.kt
