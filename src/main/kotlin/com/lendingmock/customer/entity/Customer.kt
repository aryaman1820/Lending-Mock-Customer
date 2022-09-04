package com.lendingmock.customer.entity

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import org.hibernate.validator.constraints.UniqueElements
import org.jetbrains.annotations.NotNull
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Positive
import kotlin.properties.Delegates

@Data
@Document(collection = "customer")
class Customer{
    @Id
    private lateinit var customerId:String
    @NotBlank(message = "The Customer name cannot be blank")
    private lateinit var name:String
    @NotBlank(message = "The Phone Number cannot be blank")
    @Indexed(unique = true)
    private lateinit var phoneNumber:Number
    @NotBlank(message = "The customer Email cannot be blank")
    @Indexed(unique = true)
    private lateinit var email:String
    @NotBlank(message = "The Customer's date of Birth cannot be blank")
    private lateinit var dateOfBirth:String
    @NotBlank(message = "The Customer's Adhar Number cannot be blank")
    @Positive(message = "The Customer's Adhar Number cannot be a negative value")
    @Indexed(unique = true)
    private lateinit var adharNumber:Number
    @Pattern(regexp = "^[A-Z0-9]{1,10}+\$", message = "The Customer's Pan Number can only contain upper case alphabets and numbers")
    @Indexed(unique = true)
    private lateinit var panNumber:String

    constructor(){

    }


    constructor(customerId:String, name:String, phoneNumber:Number,email:String,dateOfBirth:String, adharNumber: Number,panNumber: String){
        this.customerId = customerId
        this.name = name
        this.phoneNumber = phoneNumber
        this.email = email
        this.dateOfBirth = dateOfBirth
        this.adharNumber = adharNumber
        this.panNumber = panNumber
    }

    fun getCustomerId():String = customerId
    fun getName():String = name
    fun getPhoneNumber():Number = phoneNumber
    fun getEmail():String = email
    fun getDateOfBirth():String = dateOfBirth
    fun getAdharNumber():Number = adharNumber
    fun getPanNumber():String = panNumber

    fun setCustomerId(customerId:String){
        this.customerId = customerId
    }
    fun setName(name: String){
        this.name = name
    }
    fun setPhoneNumber(phoneNumber: Number){
        this.phoneNumber = phoneNumber
    }
    fun setEmail(email:String){
        this.email = email
    }
    fun setDateOfBirth(dateOfBirth:String){
        this.dateOfBirth = dateOfBirth
    }
    fun setAdharNumber(adharNumber: Number){
        this.adharNumber = adharNumber
    }
    fun setPanNumber(panNumber: String){
        this.panNumber = panNumber
    }

    override fun toString(): String {
        return "Customer(customerId='$customerId', name='$name', phoneNumber=$phoneNumber, email='$email', dateOfBirth='$dateOfBirth', adharNumber=$adharNumber, panNumber='$panNumber')"
    }


}