package com.example.data.api.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PagedResponseItem(
    val name: String,
    val url: String,
)