package com.lendingmock.customer.utils

import com.lendingmock.customer.entity.Customer
import com.lendingmock.customer.model.CustomerDto
import org.springframework.beans.BeanUtils
import reactor.core.publisher.Mono

class AppUtils {

    fun entityToDto(customer: Customer):CustomerDto{
        val customerDto = CustomerDto()
        BeanUtils.copyProperties(customer,customerDto)
        return customerDto
    }

    fun dtoToEntity(customerDto: Mono<CustomerDto>):Customer{
        val customer = Customer()
        BeanUtils.copyProperties(customerDto,customer)
        return customer
    }
}