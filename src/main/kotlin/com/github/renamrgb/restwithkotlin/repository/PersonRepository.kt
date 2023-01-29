package com.github.renamrgb.restwithkotlin.repository

import com.github.renamrgb.restwithkotlin.model.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Long?>