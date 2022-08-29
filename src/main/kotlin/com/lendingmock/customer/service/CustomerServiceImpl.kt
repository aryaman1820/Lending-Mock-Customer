package com.lendingmock.customer.service

import com.lendingmock.customer.entity.Customer
import com.lendingmock.customer.exception.BadCredentials
import com.lendingmock.customer.exception.CustomerNotFoundException
import com.lendingmock.customer.model.LoginDto
import com.lendingmock.customer.repository.CustomerRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono


@Service
class CustomerServiceImpl(private val customerRepository: CustomerRepository) : CustomerService {

    var bool:Boolean = false

    // function for login
    override fun validateLogin(loginDto: LoginDto): Mono<Customer> {
        val response = customerRepository.existsByPhoneNumber(loginDto.getPhoneNumber())
        if(response.mapNotNull() ){
            val customer = customerRepository.getCustomerByPhoneNumber(loginDto.getPhoneNumber())
            val dOB = customer.map(Customer::getDateOfBirth)

            if(loginDto.getDOB().toMono() == dOB){
                return customer
            }
            else{
                throw BadCredentials("Bad Credentials Inputted!!!")
            }

        }
        else{
            throw CustomerNotFoundException("Customer Not Found!!!")
        }
    }

    //Method to register a new customer
    override fun registerNewCustomer(customer: Customer): Mono<Customer> {
        return customerRepository.save(customer)
    }


}