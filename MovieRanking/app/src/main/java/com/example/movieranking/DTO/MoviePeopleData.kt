package com.example.movieranking.DTO

data class MoviePeopleData(
    val peopleListResult: peopleListResult,
)

data class peopleListResult(
    val peopleList: ArrayList<peopleList>,
)

data class peopleList(
    val peopleNm:String,
    val repRoleNm: String,
    val filmoNames: String,
)
