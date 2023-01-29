package com.github.renamrgb.restwithkotlin.data.vo.v1

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.dozermapper.core.Mapping
import org.springframework.hateoas.RepresentationModel


data class PersonVO(

    @Mapping("id")
    @field:JsonProperty("id")
    var key: Long = 0,

//    @field:JsonProperty("firs_name")
    var firstName: String = "",

//    @JsonProperty("last_name")
    var lastName: String = "",

    var address: String = "",

    var gender: String = "",
) : RepresentationModel<PersonVO>()