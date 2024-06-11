package com.konstantinovd.blog.entities

import com.konstantinovd.blog.utils.toSlug
import jakarta.persistence.*

import java.time.LocalDateTime

@Entity
@Table(name = "articles")
class Article(
    var title: String,
    var headline: String,
    var content: String,
    @ManyToOne var author: User,
    var slug: String = title.toSlug(),
    var addedAt: LocalDateTime = LocalDateTime.now(),
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "articlesGenerator")
    @SequenceGenerator(name = "articlesGenerator", sequenceName = "s_articles", allocationSize = 1)
    var id: Long? = null)