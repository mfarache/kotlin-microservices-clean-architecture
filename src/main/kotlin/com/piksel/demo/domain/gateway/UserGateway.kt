package com.piksel.demo.domain.gateway

import com.piksel.demo.domain.entities.User

interface UserGateway {
	
	fun create (user:User) : String
	
	fun findUser (query: UserQuery) : User
	
	data class UserQuery (val username:String, val password:String)
}