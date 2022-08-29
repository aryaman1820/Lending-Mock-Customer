package com.lendingmock.customer.entity

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Data
@Document(collection = "customer")
class Customer{
    @Id
    private lateinit var customerId:String
    private lateinit var name:String
    private lateinit var phoneNumber:String
    private lateinit var email:String
    private lateinit var dateOfBirth:String

    constructor(){

    }


    constructor(customerId:String, name:String, phoneNumber:String,email:String,dateOfBirth:String){
        this.customerId = customerId
        this.name = name
        this.phoneNumber = phoneNumber
        this.email = email
        this.dateOfBirth = dateOfBirth
    }

    fun getCustomerId():String = customerId
    fun getName():String = name
    fun getPhoneNumber():String = phoneNumber
    fun getEmail():String = email
    fun getDateOfBirth():String = dateOfBirth

    fun setCustomerId(customerId:String){
        this.customerId = customerId
    }
    fun setName(name: String){
        this.name = name
    }
    fun setPhoneNumber(phoneNumber: String){
        this.phoneNumber = phoneNumber
    }
    fun setEmail(email:String){
        this.email = email
    }
    fun setDateOfBirth(dateOfBirth:String){
        this.dateOfBirth = dateOfBirth
    }


}