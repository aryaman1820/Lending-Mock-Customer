package com.lendingmock.customer.repository

import com.lendingmock.customer.entity.Admin
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface AdminRepository: ReactiveMongoRepository<Admin,Number> {

    fun getAdminByAdminName(adminName:String): Mono<Admin>
}