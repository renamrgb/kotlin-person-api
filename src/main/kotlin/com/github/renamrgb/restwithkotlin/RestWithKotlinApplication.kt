package com.github.renamrgb.restwithkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestWithKotlinApplication

fun main(args: Array<String>) {
	runApplication<RestWithKotlinApplication>(*args)
}
