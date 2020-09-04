package com.castaldelli.testlabapi.controllers

import com.castaldelli.testlabapi.model.Lab
import com.google.gson.Gson
import org.hamcrest.CoreMatchers.containsString
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@SpringBootTest //(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
internal class LabControllerTest {

    /* // Integração
    @LocalServerPort
    private val port = 0
    @Autowired
    lateinit var restTemplate: TestRestTemplate
     */

    @Autowired
    lateinit var mck: MockMvc


    @Test
    fun createLab_success() {

        val labTest = Lab(description = "Teste Unitário", city = "Unit City", status = true)

        // Teste Unitário
        mck.perform(post("/lab")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(Gson().toJson(labTest))
            ).andDo(print())
                .andExpect(status().isOk)
                .andExpect(content().string(containsString("criado com sucesso")))

        /* // Integração
        val ret = restTemplate.postForEntity("http://localhost:$port/lab",HttpEntity(labTest), String::class.java)

        assertNotNull(ret)
        assertThat(ret.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(ret.body).contains("criado com sucesso")*/

    }

    @Test
    fun createLab_badRequest() {
        mck.perform(post("/lab")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content("bad request")
        ).andDo(print())
                .andExpect(status().isBadRequest)
                .andExpect(content().string(containsString("Bad request")))
    }

    @Test
    fun getAllLabs_empty() {
        mck.perform(get("/lab")).andDo(print())
                .andExpect(status().isOk)
                .andExpect(content().json("[]"))
    }

    @Test
    fun getLab_notFound() {
        mck.perform(get("/lab/1")).andDo(print())
                .andExpect(status().isNotFound)
    }
}