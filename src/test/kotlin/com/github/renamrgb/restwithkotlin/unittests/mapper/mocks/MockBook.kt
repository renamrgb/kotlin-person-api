package com.github.renamrgb.restwithkotlin.unittests.mapper.mocks

import com.github.renamrgb.restwithkotlin.data.vo.v1.BookVO
import com.github.renamrgb.restwithkotlin.model.Book

class MockBook {

    fun mockEntityList(): ArrayList<Book> {
        val books: ArrayList<Book> = ArrayList<Book>()
        for (i in 0..13) {
            books.add(mockEntity(i))
        }
        return books
    }

    fun mockVOList(): ArrayList<BookVO> {
        val books: ArrayList<BookVO> = ArrayList()
        for (i in 0..13) {
            books.add(mockVO(i))
        }
        return books
    }

    fun mockEntity(number: Int) = Book(
            id = number.toLong(),
            author = "Some Author$number",
            price = 25.0,
            title = "Some Title$number"
        )

    fun mockVO(number: Int) = BookVO(
            key = number.toLong(),
            author = "Some Author$number",
            price = 25.0,
            title = "Some Title$number"
        )
}