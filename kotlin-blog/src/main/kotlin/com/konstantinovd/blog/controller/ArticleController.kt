package com.konstantinovd.blog.controller

import com.konstantinovd.blog.repository.ArticleRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("api/article")
class ArticleController(private val repository: ArticleRepository) {

    @GetMapping("/")
    fun findAll() = repository.findAllByOrderByAddedAtDesc()

    fun findOne(@PathVariable slug: String) = repository.findBySlug(slug)
        ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "This article does not exist")

}