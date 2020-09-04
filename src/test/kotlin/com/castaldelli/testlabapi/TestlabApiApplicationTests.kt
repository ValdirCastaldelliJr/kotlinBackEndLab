package com.castaldelli.testlabapi

import com.castaldelli.testlabapi.controllers.LabController
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TestlabApiApplicationTests {

    // Smoke Test
    @Autowired
    private lateinit var controller: LabController

    @Test
    fun contextLoads() {
        assertThat(controller).isNotNull;
    }

}
