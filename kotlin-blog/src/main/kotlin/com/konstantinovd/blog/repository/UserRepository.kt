package com.konstantinovd.blog.repository

import com.konstantinovd.blog.entities.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByLogin(login: String): User?
}