package com.lendingmock.customer.controller

import com.lendingmock.customer.entity.Customer
import com.lendingmock.customer.exception.DeletionFailedException
import com.lendingmock.customer.model.LoginDto
import com.lendingmock.customer.service.CustomerServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.function.Function

@RestController
@RequestMapping("/v1/customer")
class CustomerController(private val customerServiceImpl: CustomerServiceImpl) {

    @PostMapping("/register")
    fun registerNewCustomer(@RequestBody customerDto: Customer):Mono<ResponseEntity<Customer>>{
        return customerServiceImpl.registerNewCustomer(customerDto)
            .map{customer:Customer -> ResponseEntity.status(HttpStatus.CREATED).body(customer)}
            .switchIfEmpty(Mono.just(ResponseEntity.badRequest().build()))
    }
    @PostMapping("/login")
    fun validateLogin(@RequestBody loginDto: LoginDto):Mono<ResponseEntity<Customer>>{
        return customerServiceImpl.validateLogin(loginDto)
            .map{ customer: Customer -> ResponseEntity.ok().body(customer) }
            .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()))
    }

    @GetMapping()
    fun getAllCustomer():Flux<Customer>{
        return customerServiceImpl.getAllCustomers()
    }


    @DeleteMapping("/delete/{customerId}")
    fun deleteCustomer(@PathVariable("customerId") customerId:String):Mono<ResponseEntity<String>>{
        return customerServiceImpl.deleteCustomerById(customerId)
            .map { ResponseEntity.ok().body("Customer with id: '$customerId' deleted successfully " ) }

    }

}