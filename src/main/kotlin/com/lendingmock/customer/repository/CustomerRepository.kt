package com.lendingmock.customer.repository

import com.lendingmock.customer.entity.Customer
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface CustomerRepository : ReactiveMongoRepository<Customer,String>{

    fun getCustomerByPhoneNumber(phoneNumber:String):Mono<Customer>

    fun existsByPhoneNumber(phoneNumber: String):Mono<Boolean>
}