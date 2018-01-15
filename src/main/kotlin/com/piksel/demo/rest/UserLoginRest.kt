package com.piksel.demo.rest

import com.piksel.demo.boundaries.UserLogin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable

import com.piksel.demo.boundaries.UserLogin.LoginRequest
import org.springframework.web.bind.annotation.RequestBody

@RestController
class UserLoginRest (val useCase: UserLogin) {
	    class UILoginRequest constructor (val username: String,  val password:String) {
			constructor () : this("","") {
			} 
		}
	
		@PostMapping("/login")
		fun login( @RequestBody userData: UILoginRequest) {
			val response = useCase.login(LoginRequest (userData.username, userData.password))
		} 
}