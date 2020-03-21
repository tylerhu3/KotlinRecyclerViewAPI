package com.example.zapapp

/**
 * Data Class to hold individual json objects from http://jsonplaceholder.typicode.com/photos
 *
 * */
data class Item
    (val albumId: Int, val id: Int, val title: String, val url: String, val thumbnailUrl: String)