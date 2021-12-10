package com.example.movieranking.DTO

data class DetailMovieData(
    val movieInfoResult: movieInfoResult,
)

data class movieInfoResult(
    val movieInfo: movieInfo,
)

data class movieInfo(
    val movieNm: String,
    val openDt: String,
    val prdtStatNm: String,
    val typeNm: String,
    val actors: ArrayList<actors>,
)

data class actors(
    val peopleNm: String,
    val cast: String,
)
