package com.lendingmock.customer.controller


import com.lendingmock.customer.entity.Customer
import com.lendingmock.customer.service.CustomerServiceImpl
import org.junit.jupiter.api.Test
import org.mockito.Mockito

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean


import org.springframework.test.web.reactive.server.WebTestClient



@WebFluxTest(CustomerController::class)
@AutoConfigureWebTestClient
internal class CustomerControllerTest {

    @Autowired
    private val webTestClient:WebTestClient? = null

    @MockBean
    private val customerServiceImpl:CustomerServiceImpl? = null


}