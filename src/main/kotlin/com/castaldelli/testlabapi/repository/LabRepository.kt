package com.castaldelli.testlabapi.repository

import com.castaldelli.testlabapi.model.Lab
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LabRepository: JpaRepository<Lab, Long>