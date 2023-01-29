package com.github.renamrgb.restwithkotlin.repository

import com.github.renamrgb.restwithkotlin.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository


@Repository
interface UserRepository : JpaRepository<User?, Long?> {
    @Query("SELECT u FROM User u WHERE u.userName =:userName")
    fun findByUsername(@Param("username") userName : String?) : User?
}