package com.ortalesoft.letsshop.domain.model.responses

import com.ortalesoft.letsshop.domain.model.HouseHold
import com.ortalesoft.letsshop.domain.model.User

data class SignUpResponse(
    val user: User,
    val houseHold: HouseHold,
    val token: String
)