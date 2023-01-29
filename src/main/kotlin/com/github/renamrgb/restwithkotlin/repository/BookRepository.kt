package com.github.renamrgb.restwithkotlin.repository

import com.github.renamrgb.restwithkotlin.model.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface BookRepository : JpaRepository<Book, Long?>