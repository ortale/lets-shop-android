package com.ortalesoft.letsshop.domain.model

data class User(
    val id: String? = null,
    var name: String? = null,
    var email: String,
    var password: String
)