package com.piksel.demo.boundaries

interface UserRegister {
	
	fun register( request: RegisterRequest) : RegisterResponse
	
	data class RegisterRequest (val username:String, val password:String)
	
	data class RegisterResponse (val userData: RegisterData) {
		data class RegisterData (val id:String)
	} 
	
}