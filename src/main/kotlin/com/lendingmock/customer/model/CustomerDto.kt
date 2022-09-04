package com.lendingmock.customer.model

class CustomerDto {


    private lateinit var name:String
    private lateinit var phoneNumber:Number
    private lateinit var email:String
    private lateinit var dateOfBirth:String
    private lateinit var adharNumber:Number
    private lateinit var panNumber:String


    fun getName():String = name
    fun getPhoneNumber():Number = phoneNumber
    fun getEmail():String = email
    fun getDateOfBirth():String = dateOfBirth
    fun getAdharNumber():Number = adharNumber
    fun getPanNumber():String = panNumber


    fun setName(name:String){
        this.name = name
    }
    fun setPhoneNumber(phoneNumber:Number){
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
        return "CustomerDto(name='$name', phoneNumber='$phoneNumber', email='$email', dateOfBirth='$dateOfBirth', adharNumber=$adharNumber, panNumber='$panNumber')"
    }


}