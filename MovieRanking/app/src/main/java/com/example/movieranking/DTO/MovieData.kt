package com.example.movieranking.DTO

data class MovieData(
    val boxOfficeResult: boxOfficeResult
)

data class boxOfficeResult(
    val dailyBoxOfficeList: ArrayList<dailyBoxOfficeList>
)

data class dailyBoxOfficeList(
    val rank: String,
    val movieNm: String,
    val salesAcc: String,
    val audiAcc: String
)
