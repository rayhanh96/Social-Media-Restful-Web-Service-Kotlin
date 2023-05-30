package com.socialmedia.rest.webservices.socialmediarestfulwebservice.helloworld

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {
    @GetMapping("/hello-world")
    fun helloWorld() = "Hello World!"

    @GetMapping("/hello-world-bean")
    fun helloWorldBean(): HelloWorldBean = HelloWorldBean("Hello Rayhan Hussain")

    @GetMapping("/hello-world-bean/{name}")
    fun helloWorldBeanPathVariable(@PathVariable name: String): HelloWorldBean = HelloWorldBean("Hello " + name)
}