package com.castaldelli.testlabapi.model

import javax.persistence.*

@Entity
data class Lab (
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     val id: Long? = null,
     val description: String = "",
     val city: String = "",
     val status: Boolean = true
)