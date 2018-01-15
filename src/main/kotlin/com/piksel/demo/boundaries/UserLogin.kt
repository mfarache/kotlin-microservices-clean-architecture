package com.piksel.demo.boundaries

interface UserLogin {
	
	fun login( request: LoginRequest) : LoginResponse

	
	data class LoginRequest (val username:String, val password:String)
	
	data class LoginResponse (val userData: UserData) {
		data class UserData (val username:String)
	} 
	
}