package com.lendingmock.customer.service

import com.lendingmock.customer.entity.Admin
import com.lendingmock.customer.exception.AdminAlreadyExistsException
import com.lendingmock.customer.exception.BadCredentials
import com.lendingmock.customer.repository.AdminRepository
import com.mongodb.DuplicateKeyException
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.lang.Exception

@Service
class AdminServiceImpl(private val adminRepository: AdminRepository):AdminService {

    override fun adminLogin(admin: Admin): Mono<Admin> {
        return adminRepository.getAdminByAdminName(admin.getAdminName())
            .filter {tempAdmin -> tempAdmin.getAdminPassword() == admin.getAdminPassword()}
            .switchIfEmpty(Mono.error(BadCredentials("Invalid Credentials!!!")))
    }

    override fun addNewAdmin(admin: Admin): Mono<Admin> {
            return adminRepository.save(admin)
    }

    override fun approveAdmin(adminName: String): Mono<Admin> {
        return adminRepository.getAdminByAdminName(adminName)
            .flatMap { dbAdmin ->
                dbAdmin.setIsApproved(true)
                adminRepository.save(dbAdmin)
            }
    }
}