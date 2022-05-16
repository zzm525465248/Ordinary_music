package com.example.kotlin_jetpack.bean

data class SongUser(
    val code: Int,
    val result: Result
)

data class Result(
    val artist: List<Artist>,
    val orders: List<String>
)

data class Artist(
    val albumSize: Int,
    val alg: String,
    val alias: List<Any>,
    val briefDesc: String,
    val fansSize: Int,
    val id: Int,
    val img1v1Id: Long,
    val img1v1Id_str: String,
    val img1v1Url: String,
    val musicSize: Int,
    val mvSize: Int,
    val name: String,
    val occupation: String,
    val officialTags: List<Any>,
    val picId: Long,
    val picId_str: String,
    val picUrl: String,
    val searchCircle: SearchCircle,
    val trans: String,
    val transNames: Any,
    val videoSize: Int
)

data class SearchCircle(
    val entranceText: String,
    val entranceUrl: String,
    val id: String
)