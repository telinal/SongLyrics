package com.example.songlyrics.model

data class Hits(
    val highlights: List<Any>,
    val index: String,
    val result: Result,
    val type: String
)