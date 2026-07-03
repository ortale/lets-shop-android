package com.ortalesoft.letsshop.domain.model

data class User(
    val id: String? = null,
    val name: String? = null,
    var email: String,
    var password: String
)