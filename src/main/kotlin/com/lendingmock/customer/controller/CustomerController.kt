package com.lendingmock.customer.controller

import com.lendingmock.customer.entity.Customer
import com.lendingmock.customer.model.CustomerDto
import com.lendingmock.customer.model.LoginDto
import com.lendingmock.customer.service.CustomerServiceImpl
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/v1/customer")
class CustomerController(private val customerServiceImpl: CustomerServiceImpl) {

    @PostMapping("/register")
    fun registerNewCustomer(@RequestBody customer: Customer):Mono<Customer>{
        return customerServiceImpl.registerNewCustomer(customer)
    }
    @PostMapping("/login")
    fun validateLogin(@RequestBody loginDto: LoginDto):Mono<Customer>{
        return customerServiceImpl.validateLogin(loginDto)
    }
}