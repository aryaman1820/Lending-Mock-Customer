package com.lendingmock.customer.model

class LoginDto {

    private lateinit var phoneNumber:String
    private lateinit var dOB:String

    constructor(){

    }

    constructor(phoneNumber: String, dOB: String){
        this.phoneNumber = phoneNumber
        this.dOB = dOB
    }

    fun getPhoneNumber():String = phoneNumber

    fun getDOB():String = dOB


    fun setPhoneNumber(phoneNumber:String){
        this.phoneNumber = phoneNumber
    }

    fun setDOB(dOB:String){
        this.dOB = dOB
    }
}