package com.castaldelli.testlabapi.service

import com.castaldelli.testlabapi.model.Lab
import com.castaldelli.testlabapi.repository.LabRepository
import org.springframework.stereotype.Component

@Component
class LabServiceImpl(val repo: LabRepository) : LabService {

    override fun getById(id: Long) = repo.getOne(id)
    override fun getAll(): List<Lab> = repo.findAll()
    override fun create(lab: Lab) = repo.save(lab)

    override fun delete(id: Long) {
        repo.deleteById(id)
    }

    override fun update(lab: Lab) {
        repo.save(lab)
    }
}