package com.github.renamrgb.restwithkotlin.model

import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority

@Entity
@Table(name = "PERMISSION")
data class Permission(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "description", nullable = true, length = 255)
    var description: String? = null

    ) : GrantedAuthority {
    override fun getAuthority() = description!!
}
