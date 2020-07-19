package com.example.lab3

import java.util.ArrayList

class Response : ArrayList<ResponseItem>()

data class ResponseItem(
    val _links: Links,
    val id: Int,
    val subtype: String,
    val title: String,
    val type: String,
    val url: String
)

data class Links(
    val about: List<About>,
    val collection: List<Collection>,
    val self: List<Self>
)

data class About(
    val href: String
)

data class Collection(
    val href: String
)

data class Self(
    val embeddable: Boolean,
    val href: String
)