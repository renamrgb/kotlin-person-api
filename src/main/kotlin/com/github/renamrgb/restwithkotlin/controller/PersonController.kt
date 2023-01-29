package com.github.renamrgb.restwithkotlin.controller


import com.github.renamrgb.restwithkotlin.data.vo.v1.PersonVO
import com.github.renamrgb.restwithkotlin.services.PersonService
import com.github.renamrgb.restwithkotlin.util.constants.MediaType
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(
    value = ["person"],
    produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML],
    consumes = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML]
)
@Tag(name = "People", description = "Endpoint for managing People")
class PersonController(val service: PersonService) {

    @GetMapping
    @Operation(
        summary = "Finds all Peoples", description = "Finds all Peoples",
        tags = ["Peoples"],
        responses = [
            ApiResponse(
                description = "Success",
                responseCode = "200",
                content = [
                    Content(array = ArraySchema(schema = Schema(implementation = PersonVO::class)))
                ]
            ),
            ApiResponse(
                description = "No content",
                responseCode = "204",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
        ]
    )
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