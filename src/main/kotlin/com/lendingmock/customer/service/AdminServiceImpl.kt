package com.lendingmock.customer.service

import com.lendingmock.customer.entity.Admin
import com.lendingmock.customer.exception.AdminAlreadyExistsException
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
    }

    override fun addNewAdmin(admin: Admin): Mono<Admin> {
        try {
            return adminRepository.save(admin)
        }
        catch (e:Exception){
            throw AdminAlreadyExistsException("The Admin already Exists!!!")
        }

    }

    override fun approveAdmin(adminName: String): Mono<Admin> {
        return adminRepository.getAdminByAdminName(adminName)
            .flatMap { dbUser ->
                dbUser.setIsApproved(true)
                adminRepository.save(dbUser)
            }
    }
}