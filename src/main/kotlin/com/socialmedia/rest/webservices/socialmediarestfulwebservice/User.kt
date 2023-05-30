package com.socialmedia.rest.webservices.socialmediarestfulwebservice

import jakarta.validation.constraints.Past
import jakarta.validation.constraints.Size
import java.time.LocalDate

data class User(var id: Int,
                @field:Size(min = 2, message = "Name should have a minimum of two characters") val name: String,
                @field:Past(message = "Birth date should be in the past") val birthdate: LocalDate)
