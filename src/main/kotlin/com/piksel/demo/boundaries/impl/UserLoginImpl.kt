package com.piksel.demo.boundaries.impl

import com.piksel.demo.domain.gateway.UserGateway
import com.piksel.demo.boundaries.UserLogin
import com.piksel.demo.domain.entities.User
import org.springframework.stereotype.Component

@Component
class UserLoginImpl(val user: UserGateway): UserLogin {
	
	override fun login(request: UserLogin.LoginRequest): UserLogin.LoginResponse {
		return user.findUser(UserGateway.UserQuery(request.username, request.password)).toLoginResponse()
	}
	
	fun User.toLoginResponse(): UserLogin.LoginResponse {
		return UserLogin.LoginResponse(UserLogin.LoginResponse.UserData(username))
	}
}