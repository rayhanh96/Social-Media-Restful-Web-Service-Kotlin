package com.socialmedia.rest.webservices.socialmediarestfulwebservice

import java.time.LocalDateTime

data class ErrorDetails(val timeStamp: LocalDateTime, val message: MutableList<String?>, val details: String)
