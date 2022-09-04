package com.lendingmock.customer.controller

import com.lendingmock.customer.entity.Customer
import com.lendingmock.customer.exception.BadCredentials
import com.lendingmock.customer.model.CustomerDto
import com.lendingmock.customer.model.LoginDto
import com.lendingmock.customer.service.CustomerServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.onErrorReturn
import reactor.kotlin.core.publisher.switchIfEmpty
import java.util.function.Function

@RestController
@RequestMapping("/v1/customer")
class CustomerController(private val customerServiceImpl: CustomerServiceImpl) {

    @PostMapping("/register")
    fun registerNewCustomer(@RequestBody customerDto: Customer):Mono<ResponseEntity<Customer>>{
        return customerServiceImpl.registerNewCustomer(customerDto)
            .map<ResponseEntity<Customer>>(Function{customer:Customer -> ResponseEntity.status(HttpStatus.CREATED).body(customer)})
            .switchIfEmpty(Mono.just(ResponseEntity.badRequest().build()))
    }
    @PostMapping("/login")
    fun validateLogin(@RequestBody loginDto: LoginDto):Mono<ResponseEntity<Customer>>{
        return customerServiceImpl.validateLogin(loginDto)
            .map<ResponseEntity<Customer>>(Function { customer: Customer -> ResponseEntity.ok().body(customer) })
            .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()))
    }

    @GetMapping()
    fun getAllCustomer():Flux<Customer>{
        return customerServiceImpl.getAllCustomers()
    }


}