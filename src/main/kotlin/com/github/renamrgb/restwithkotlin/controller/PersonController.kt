package com.github.renamrgb.restwithkotlin.controller


import com.github.renamrgb.restwithkotlin.data.vo.v1.PersonVO
import com.github.renamrgb.restwithkotlin.services.PersonService
import com.github.renamrgb.restwithkotlin.util.constants.MediaType
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(value = ["person"],
    produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML],
    consumes = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML])
class PersonController(val service: PersonService) {

    @GetMapping
    fun findAll(): List<PersonVO> {
        return service.findAll()
    }

    @GetMapping(value = ["{id}"])
    fun findById(@PathVariable id: Long): PersonVO {
        return service.findById(id)
    }

    @PostMapping
    fun create(@RequestBody personVo: PersonVO): PersonVO {
        return service.create(personVo)
    }

    @PutMapping(value = ["{id}"])
    fun update(@PathVariable id: Long, @RequestBody personVo: PersonVO): PersonVO {
        return service.update(id, personVo)
    }

    @DeleteMapping(value = ["{id}"])
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }

}