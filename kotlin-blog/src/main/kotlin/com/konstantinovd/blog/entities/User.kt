package com.konstantinovd.blog.entities

import jakarta.persistence.*

@Entity
@Table(name = "users")
class User(
    @Column(nullable = false)
    var login: String,
    @Column(nullable = false)
    var firstname: String,
    @Column(nullable = false)
    var lastname: String,
    var description: String? = null,
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usersGenerator")
    @SequenceGenerator(name = "usersGenerator", sequenceName = "s_users", allocationSize = 1)
    var id: Long? = null)