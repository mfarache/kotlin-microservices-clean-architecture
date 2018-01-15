package com.piksel.demo.boundaries.impl

import com.piksel.demo.domain.gateway.UserGateway

import com.piksel.demo.boundaries.UserRegister
import com.piksel.demo.boundaries.UserRegister.RegisterRequest
import com.piksel.demo.boundaries.UserRegister.RegisterResponse
import com.piksel.demo.boundaries.UserRegister.RegisterResponse.RegisterData
import com.piksel.demo.domain.entities.User
import org.springframework.stereotype.Component

@Component
class UserRegisterImpl(val user: UserGateway): UserRegister {
	
	override fun register(request: RegisterRequest): RegisterResponse {
		val id = user.create(request.toUser())
		return RegisterResponse(RegisterData(id))
	}
	
	fun RegisterRequest.toUser(): User {
		return User("", username, password)
	}
}