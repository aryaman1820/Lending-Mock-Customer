package com.lendingmock.customer.controller

import com.lendingmock.customer.entity.Admin
import com.lendingmock.customer.entity.Customer
import com.lendingmock.customer.service.AdminServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.util.function.Function


@RestController
@RequestMapping("/v1/admin")
class AdminController(private val adminServiceImpl: AdminServiceImpl) {

    @PostMapping("/login")

    fun adminLogin(@RequestBody admin:Admin):Mono<ResponseEntity<Admin>>{
        return adminServiceImpl.adminLogin(admin)
            .map<ResponseEntity<Admin>>(Function { admin: Admin -> ResponseEntity.ok().body(admin) })
            .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()))

    }

    @PostMapping("/register")
    fun addNewAdmin(@RequestBody admin:Admin):Mono<Admin>{
        return adminServiceImpl.addNewAdmin(admin)

    }

    @PutMapping("/approve/{adminName}")
    fun approveAdmin(@PathVariable adminName:String):Mono<Admin>{
        return adminServiceImpl.approveAdmin(adminName)
    }
}