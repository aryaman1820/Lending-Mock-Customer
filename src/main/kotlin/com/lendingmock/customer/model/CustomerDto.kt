package com.lendingmock.customer.model

class CustomerDto {

    private lateinit var customerId:String
    private lateinit var name:String
    private lateinit var phoneNumber:String
    private lateinit var email:String
    private lateinit var dateOfBirth:String

    fun getCustomerId():String = customerId
    fun getName():String = name
    fun getPhoneNumber():String = phoneNumber
    fun getEmail():String = email
    fun getDateOfBirth():String = dateOfBirth

    fun setCustomerId(customerId:String){
        this.customerId = customerId
    }
    fun setName(name:String){
        this.name = name
    }
    fun setPhoneNumber(phoneNumber:String){
        this.phoneNumber = phoneNumber
    }
    fun setEmail(email:String){
        this.email = email
    }
    fun setDateOfBirth(dateOfBirth:String){
        this.dateOfBirth = dateOfBirth
    }

    override fun toString(): String {
        return "CustomerDto(customerId='$customerId', name='$name', phoneNumber='$phoneNumber', email='$email', dateOfBirth='$dateOfBirth')"
    }


}