package com.github.renamrgb.restwithkotlin.services

import com.github.renamrgb.restwithkotlin.controller.PersonController
import com.github.renamrgb.restwithkotlin.data.vo.v1.PersonVO
import com.github.renamrgb.restwithkotlin.exceptions.RequiredObjectIsNullException
import com.github.renamrgb.restwithkotlin.exceptions.ResourceNotFoundException
import com.github.renamrgb.restwithkotlin.mapper.DozerMapper
import com.github.renamrgb.restwithkotlin.model.Person
import com.github.renamrgb.restwithkotlin.repository.PersonRepository
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.stereotype.Service
import java.util.*
import java.util.logging.Logger

@Service
class PersonService(val repository: PersonRepository) {

    private val logger = Logger.getLogger(PersonService::class.java.name);

    fun findAll(): List<PersonVO> {
        logger.info("Finding all person")
        val persons = repository.findAll()

        val personVOS = DozerMapper.parseListObjects(persons, PersonVO::class.java)

        for( p in personVOS) {
            val whithSelfRel  = linkTo(PersonController::class.java)
                .slash(p.key).withSelfRel()
            p.add(whithSelfRel)
        }

        return personVOS
    }

    fun findById(id: Long): PersonVO {
        logger.info("Finding one person by id $id")

        val person = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this id") }
        val personVo = DozerMapper.parseObject(person, PersonVO::class.java)
        val whithSelfRel  = linkTo(PersonController::class.java)
            .slash(personVo.key).withSelfRel()
        personVo.add(whithSelfRel)
        return personVo
    }

    fun create(personVo: PersonVO?): PersonVO {
        logger.info("Create one person with name ${personVo?.firstName}")
        if(Objects.isNull(personVo)) throw RequiredObjectIsNullException()
        val entity: Person = DozerMapper.parseObject(personVo, Person::class.java)
        val personVO = DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)
        val whithSelfRel  = linkTo(PersonController::class.java)
            .slash(personVO.key).withSelfRel()
        personVO.add(whithSelfRel)
        return personVO
    }

    fun update(id: Long, person: PersonVO?): PersonVO {
        if(Objects.isNull(person)) throw RequiredObjectIsNullException()
        logger.info("Update one person with id $id")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this id") }

        entity.firstName = person!!.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender

        val personVO = DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)
        val whithSelfRel  = linkTo(PersonController::class.java)
            .slash(personVO.key).withSelfRel()
        personVO.add(whithSelfRel)
        return personVO
    }

    fun delete(id: Long) {
        repository.deleteById(id);
    }

}