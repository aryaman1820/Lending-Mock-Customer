package com.lendingmock.customer.service

import com.lendingmock.customer.entity.Customer
import com.lendingmock.customer.model.LoginDto
import com.lendingmock.customer.repository.CustomerRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

internal class CustomerServiceImplTest {

    private val customerRepository:CustomerRepository = mockk()
    private val customerServiceImpl = CustomerServiceImpl(customerRepository)

    private val customer1 = Customer("01","Aryaan",456,"a@a.com","20/01/1999",123,"456")
    private val customer2 = Customer("02","Vishal",789,"v@v.com","01/01/1998",789,"4159")

    private val monoCustomer1 = Mono.just(customer1)

    private val fluxCustomer = Flux.just(customer1,customer2)

    @Test
    fun validateLogin() {
        val loginDto =LoginDto(456,"20/01/1999")


        every { customerRepository.getCustomerByPhoneNumber(loginDto.getPhoneNumber()) } returns monoCustomer1

        val testLogin = customerServiceImpl.validateLogin(loginDto)

        verify(exactly = 1) { customerRepository.getCustomerByPhoneNumber(loginDto.getPhoneNumber()) }
        Assertions.assertEquals(monoCustomer1,testLogin)
    }

    @Test
    fun registerNewCustomer() {
    }

    @Test
    fun getAllCustomers() {
    }

    @Test
    fun deleteCustomerById() {
    }
}