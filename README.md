
<h1 align="center">Disney Infos(DisneyMotions)</h1></br>
<p align="center">  
A demo Disney app using <a href="https://material.io/design/motion/the-motion-system.html" target="_blank"> transformation motions </a> based on MVVM architecture.<br>
The motion system is included in the 1.2.0-alpha05 released material version.
</p>
</br>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
  <a href="https://github.com/skydoves/DisneyMotions/actions"><img alt="Build Status" src="https://github.com/skydoves/DisneyMotions/workflows/Android%20CI/badge.svg"/></a> 
</p>

# Project Developed using Api Disney and Database local

## Tech stack & Open-source libraries
- Minimum SDK level 21
- 100% [Kotlin](https://kotlinlang.org/) based + [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous.
- JetPack
  - LiveData - notify domain layer data to views.
  - Lifecycle - dispose observing data when lifecycle state changes.
  - ViewModel - UI related data holder, lifecycle aware.
  - Room Persistence - construct database.
- Architecture
  - MVVM Architecture (View - DataBinding - ViewModel - Model)
  - Repository pattern
  - [Koin](https://github.com/InsertKoinIO/koin) - dependency injection
- Material Design & Animations
- [Retrofit2 & Gson](https://github.com/square/retrofit) - constructing the REST API
- [OkHttp3](https://github.com/square/okhttp) - implementing interceptor, logging and mocking web server
- [Glide](https://github.com/bumptech/glide) - loading images
- [BaseRecyclerViewAdapter](https://github.com/skydoves/BaseRecyclerViewAdapter) - implementing adapters and viewHolders
- [WhatIf](https://github.com/skydoves/whatif) - checking nullable object and empty collections more fluently
- [Timber](https://github.com/JakeWharton/timber) - logging
- Ripple animation, Shared element container transform/transition

Recyclerview was used to show the message on one side of a color and the other color on the other side

# :point_right: Main functions of the application
- [x] Main Activity
- [x] Bottom Bar
- [x] Transition next activity
- [x] Glide Image

# :camera: Screenshots
<img src="https://github.com/RafaelMScience/Archives/blob/main/DisneyInfos/DisneyList.jpeg?raw=true" width="200"> <img src="https://github.com/RafaelMScience/Archives/blob/main/DisneyInfos/DisneyMain.jpeg?raw=true" width="200"> <img src="https://github.com/RafaelMScience/Archives/blob/main/DisneyInfos/DisneyRadio.jpeg?raw=true" width="200"> <img src="https://github.com/RafaelMScience/Archives/blob/main/DisneyInfos/DisneyInfoMovie.jpeg?raw=true" width="200">

# Info Extras
- Project was manually rewritten to understand MVVM architecture
- DI
- Jetpack Compose further
- Project transcribed for study only project developed by
  - [Jaewoong Eum](https://github.com/skydoves/DisneyMotions)
