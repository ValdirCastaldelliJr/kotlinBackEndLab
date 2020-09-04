package com.castaldelli.testlabapi.controllers

import com.castaldelli.testlabapi.model.Lab
import com.castaldelli.testlabapi.service.LabService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/lab"])
class LabController {

    @Autowired
    lateinit var service : LabService

    @PostMapping
    fun createLab(@RequestBody lab: Lab) : ResponseEntity<String> {
        val entity = service.create(lab)
        return ResponseEntity("Lab ${entity.id} criado com sucesso", HttpStatus.OK)
    }

    @GetMapping
    fun getAllLabs() : ResponseEntity<List<Lab>> {
        return ResponseEntity(service.getAll(), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getLab(@PathVariable id: String) : ResponseEntity<Lab> {
        return ResponseEntity(service.getById(id.toLong()), HttpStatus.OK)
    }

}