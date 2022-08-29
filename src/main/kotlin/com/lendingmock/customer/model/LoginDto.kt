package com.lendingmock.customer.model

class LoginDto {

    private lateinit var phoneNumber:String
    private lateinit var dateOfBirth:String

    constructor(){

    }

    constructor(phoneNumber: String, dateOfBirth: String){
        this.phoneNumber = phoneNumber
        this.dateOfBirth = dateOfBirth
    }

    fun getPhoneNumber():String = phoneNumber

    fun getDateOfBirth():String = dateOfBirth


    fun setPhoneNumber(phoneNumber:String){
        this.phoneNumber = phoneNumber
    }

    fun setDateOfBirth(dateOfBirth:String){
        this.dateOfBirth = dateOfBirth
    }
}