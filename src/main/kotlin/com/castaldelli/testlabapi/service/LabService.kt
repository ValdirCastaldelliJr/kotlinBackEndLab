package com.castaldelli.testlabapi.service

import com.castaldelli.testlabapi.model.Lab

interface LabService {
    fun getById(id : Long) : Lab?
    fun getAll(): List<Lab>?
    fun create(lab: Lab) : Lab
    fun delete(id: Long)
    fun update(lab: Lab)
}