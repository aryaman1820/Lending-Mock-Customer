package com.lendingmock.customer.service



import com.lendingmock.customer.entity.Customer
import com.lendingmock.customer.model.LoginDto
import com.lendingmock.customer.repository.CustomerRepository
import org.junit.jupiter.api.Test


import org.mockito.Mockito
import org.springframework.boot.test.mock.mockito.MockBean
import reactor.kotlin.core.publisher.toMono


internal class CustomerServiceImplTest() {

    private val customer = Customer("01","ABC",7033592833,"customer@gmail.com","20/08/1999", 503303010775, "KGGP4740R")
    private val loginDto = LoginDto(7033592833,"18/06/1999")
    @MockBean
    lateinit var mockServiceImpl:CustomerServiceImpl

    @Test
    fun validateLogin() {
        val mockCustomerRepository = Mockito.mock(CustomerRepository::class.java)
        Mockito.`when`(mockCustomerRepository.getCustomerByPhoneNumber(7033592833)).thenReturn(customer.toMono())



        Mockito.verify(mockServiceImpl).validateLogin(loginDto)
    }
}