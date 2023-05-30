package com.socialmedia.rest.webservices.socialmediarestfulwebservice

import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class UserDaoService {

    private var users = mutableListOf<User>()
    private var userCount = 0

        init{
            users.add(User(++userCount, "Layla", LocalDate.now().minusYears(20)))
            users.add(User(++userCount, "Rayhan", LocalDate.now().minusYears(26)))
            users.add(User(++userCount, "Zahra", LocalDate.now().minusYears(23)))
            users.add(User(++userCount, "Zainab", LocalDate.now().minusYears(19)))
            users.add(User(++userCount, "Zikra", LocalDate.now().minusYears(10)))
        }

    fun findAll(): List<User> = users

    fun findUser(id: Int): User? = users.firstOrNull { it.id == id }

    fun deleteUser(id: Int) = users.removeIf { it.id == id}

    fun saveUser(user: User): User {
        user.id=++userCount
        users.add(user)
        return user
    }






}