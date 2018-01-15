package com.piksel.demo.rest

import com.piksel.demo.boundaries.UserRegister
import com.piksel.demo.boundaries.UserRegister.RegisterRequest
import com.piksel.demo.boundaries.UserRegister.RegisterResponse
import com.piksel.demo.boundaries.UserRegister.RegisterResponse.RegisterData
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable


import com.piksel.demo.boundaries.UserLogin.LoginRequest
import org.springframework.web.bind.annotation.RequestBody

@RestController
class UserRegisterRest (val useCase: UserRegister) {
	
	    class UIRegisterRequest constructor (val username: String,  val password:String) {
			constructor () : this("","") {
				
			} 
		}
	
		@PostMapping("/register")
		fun register( @RequestBody userData: UIRegisterRequest) {
			//val response = useCase.register(RegisterRequest ("username", "password"))
			val response = useCase.register(RegisterRequest (userData.username, userData.password))
		} 
}