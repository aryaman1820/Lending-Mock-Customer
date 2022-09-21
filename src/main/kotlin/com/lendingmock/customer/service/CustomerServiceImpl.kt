package com.lendingmock.customer.service

import com.lendingmock.customer.entity.Customer
import com.lendingmock.customer.exception.BadCredentials
import com.lendingmock.customer.exception.CustomerNotFoundException
import com.lendingmock.customer.model.LoginDto
import com.lendingmock.customer.repository.CustomerRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono



@Service
class CustomerServiceImpl(private val customerRepository: CustomerRepository) : CustomerService {


    // function for login
    override fun validateLogin(loginDto: LoginDto): Mono<Customer> {
       return customerRepository.getCustomerByPhoneNumber(loginDto.getPhoneNumber())
           .filter{customer -> customer.getDateOfBirth() == loginDto.getDateOfBirth()}
           .switchIfEmpty(Mono.error(BadCredentials("Invalid Credentials!!!")))

    }

    //Function to register a new customer
    override fun registerNewCustomer(customer: Customer): Mono<Customer> {
        return customerRepository.save(customer)

    }

    //function to get all customers
    override fun getAllCustomers(): Flux<Customer> {
        return customerRepository.findAll()
            .switchIfEmpty(Mono.error(CustomerNotFoundException("Customers does not exist!!!")))
    }

    override fun deleteCustomerById(customerId: String): Mono<Void> {
        return customerRepository.deleteById(customerId)
    }


}