package com.piksel.demo.infradb

import com.piksel.demo.infradb.DBUser

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Service
import org.springframework.stereotype.Component

@Component
interface UserRepository : PagingAndSortingRepository<DBUser, String > {
	fun findByUsername(name:String): DBUser	
}