package com.example.songlyrics.model

data class Result(
    val annotation_count: Int,
    val api_path: String,
    val artist_names: String,
    val full_title: String,
    val header_image_thumbnail_url: String,
    val header_image_url: String,
    val id: Int,
    val lyrics_owner_id: Int,
    val lyrics_state: String,
    val path: String,
    val primary_artist: PrimaryArtist,
    val pyongs_count: Int,
    val song_art_image_thumbnail_url: String,
    val song_art_image_url: String,
    val stats: Stats,
    val title: String,
    val title_with_featured: String,
    val url: String
)