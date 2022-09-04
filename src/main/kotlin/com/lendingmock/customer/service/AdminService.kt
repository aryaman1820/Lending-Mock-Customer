package com.lendingmock.customer.service

import com.lendingmock.customer.entity.Admin
import reactor.core.publisher.Mono

interface AdminService {

    fun adminLogin(admin:Admin):Mono<Admin>

    fun addNewAdmin(admin:Admin):Mono<Admin>

    fun approveAdmin(adminName:String):Mono<Admin>
}