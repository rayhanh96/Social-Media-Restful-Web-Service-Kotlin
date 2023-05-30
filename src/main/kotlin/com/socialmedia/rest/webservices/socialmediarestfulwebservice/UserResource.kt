package com.socialmedia.rest.webservices.socialmediarestfulwebservice

import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
class UserResource(private val userDaoService: UserDaoService ) {

    @GetMapping("/users")
    fun retrieveAllUsers(): List<User> = userDaoService.findAll()

    @GetMapping("/users/{id}")
    fun retrieveUser(@PathVariable id: Int): User?{
        userDaoService.findUser(id).apply {
            if(this == null){
                throw UserNotFoundException(id)
            }
            return this
        }
    }

    @DeleteMapping("/users/{id}")
    fun deleteUser(@PathVariable id: Int){
        userDaoService.deleteUser(id)
    }

    @PostMapping("/users")
    fun createUser(@Valid @RequestBody user: User): ResponseEntity<User>{
        val savedUser = userDaoService.saveUser(user)
        val location: URI = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedUser.id)
            .toUri()
        return ResponseEntity.created(location).build()
    }
}