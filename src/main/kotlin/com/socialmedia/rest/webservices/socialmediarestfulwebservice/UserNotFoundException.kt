package com.socialmedia.rest.webservices.socialmediarestfulwebservice

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = HttpStatus.NOT_FOUND)
class UserNotFoundException(id: Int): RuntimeException("Unable to find user with id $id")
