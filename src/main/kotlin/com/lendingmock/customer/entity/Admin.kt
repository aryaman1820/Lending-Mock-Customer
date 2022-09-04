package com.lendingmock.customer.entity

import lombok.Data
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Data
@Document(collection = "Admin")
class Admin {
    @Id
    private lateinit var adminId:Number
    @Indexed(unique = true)
    private lateinit var adminName:String
    private lateinit var adminPassword:String
    private var isApproved:Boolean = false

    constructor(){

    }

    constructor(adminId: Number, adminName: String, adminPassword: String, isApproved:Boolean) {
        this.adminId = adminId
        this.adminName = adminName
        this.adminPassword = adminPassword
        this.isApproved = isApproved
    }

    fun getAdminId():Number = adminId
    fun setAdminId(adminId:Number){
        this.adminId  = adminId
    }
    fun getAdminName(): String = adminName
    fun setAdminName(adminName:String){
        this.adminName = adminName
    }

    fun getAdminPassword(): String = adminPassword

    fun setAdminPassword(adminPassword:String){
        this.adminPassword = adminPassword
    }

    fun getIsApproved(): Boolean = isApproved

    fun setIsApproved(isApproved: Boolean){
        this.isApproved = isApproved
    }



}