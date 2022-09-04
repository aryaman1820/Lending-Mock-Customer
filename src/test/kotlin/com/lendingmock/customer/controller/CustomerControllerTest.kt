package com.lendingmock.customer.controller

import com.lendingmock.customer.entity.Customer
import com.lendingmock.customer.model.LoginDto
import com.lendingmock.customer.service.CustomerServiceImpl
import lombok.extern.slf4j.Slf4j
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.test.StepVerifier

@Slf4j
@RunWith(SpringRunner::class)
@WebFluxTest(CustomerController::class)
internal class CustomerControllerTest {

    @Autowired
    private lateinit var webTestClient:WebTestClient

    @MockBean
    private lateinit var customerServiceImpl:CustomerServiceImpl

    fun getCustomerServiceImplMock(): CustomerServiceImpl {
        return customerServiceImpl
    }


    @Test
    fun getAllCustomers() {
        val customer : Flux<Customer> =Flux.just(Customer("01","ABC",7033592833,"customer@gmail.com","20/08/1999", 503303010775, "KGGP4740R"),
        Customer("02","EFG",8840984821,"customer2@gmail.com","20/08/1999",700182349076,"KGGP4741R")
        )
        `when`(customerServiceImpl.getAllCustomers())
            .thenReturn(customer)
       val responseBody : Flux<Customer> = webTestClient
            .get()
            .uri("/v1/customer")
            .exchange()
            .expectStatus().isOk
            .returnResult(Customer::class.java)
            .responseBody
        StepVerifier
            .create(responseBody)
            .expectNextCount(2)
            .verifyComplete()

    }

    @Test
    fun registerNewCustomerTest() {
       val customer = Customer("01","ABC",7033592833,"customer@gmail.com","20/08/1999", 503303010775, "KGGP4740R")

        `when`(customerServiceImpl.registerNewCustomer(customer)).thenReturn(Mono.just(customer))

        webTestClient.post().uri("/v1/customer/register")
            .body(Mono.just(customer), Customer::class.java)
            .exchange()
            .expectStatus().isCreated
            .expectBody()


    }

    @Test
    fun validateLoginTest(){
        val customer = Customer("01","ABC",7033592833,"customer@gmail.com","20/08/1999", 503303010775, "KGGP4740R")
        val loginDto = LoginDto(7033592833,"20/08/1999")

        `when`(customerServiceImpl.validateLogin(loginDto)).thenReturn(Mono.just(customer))

        webTestClient
            .post()
            .uri("v1/customer/login")
            .body(Mono.just(customer), Customer::class.java)
            .exchange()
            .expectStatus().isOk
            .expectBody()
    }

}