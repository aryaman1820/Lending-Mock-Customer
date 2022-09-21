package com.lendingmock.customer.service

import com.lendingmock.customer.entity.Customer
import com.lendingmock.customer.model.LoginDto
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CustomerService {

    fun validateLogin(loginDto: LoginDto):Mono<Customer> //to  validate login of the user

    fun registerNewCustomer(customer: Customer):Mono<Customer> //to register a new customer

    fun getAllCustomers():Flux<Customer> //to get a list of all customers

    fun deleteCustomerById(customerId:String):Mono<Void> //to delete customer by id

}