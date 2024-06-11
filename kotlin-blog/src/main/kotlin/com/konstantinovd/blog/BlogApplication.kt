package com.konstantinovd.blog

import com.konstantinovd.blog.config.BlogProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.properties.EnableConfigurationProperties


@SpringBootApplication(
    exclude = [

    ]
)
@EnableConfigurationProperties(BlogProperties::class)
class BlogApplication

fun main(args: Array<String>) {
    SpringApplicationBuilder(BlogApplication::class.java).run(*args)
}