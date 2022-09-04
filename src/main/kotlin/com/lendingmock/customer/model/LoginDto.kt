package com.lendingmock.customer.model

class LoginDto {

    private lateinit var phoneNumber:Number
    private lateinit var dateOfBirth:String

    constructor(){

    }

    constructor(phoneNumber: Number, dateOfBirth: String){
        this.phoneNumber = phoneNumber
        this.dateOfBirth = dateOfBirth
    }

    fun getPhoneNumber():Number = phoneNumber

    fun getDateOfBirth():String = dateOfBirth


    fun setPhoneNumber(phoneNumber:Number){
        this.phoneNumber = phoneNumber
    }

    fun setDateOfBirth(dateOfBirth:String){
        this.dateOfBirth = dateOfBirth
    }
}