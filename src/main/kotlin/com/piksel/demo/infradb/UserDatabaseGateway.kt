package com.piksel.demo.infradb

import com.piksel.demo.domain.gateway.UserGateway
import com.piksel.demo.domain.entities.User
import com.piksel.demo.infradb.DBUser
import org.springframework.stereotype.Component
import com.piksel.demo.infradb.UserRepository
import org.springframework.beans.factory.annotation.Autowired

@Component
class UserDatabaseGateway @Autowired constructor ( val repository: UserRepository): UserGateway {
	
	override fun create(user: User): String {
		val saved = repository.save(user.toDBUser())
		return saved.id
	}

	override fun findUser(query: UserGateway.UserQuery): User {
		return repository.findByUsername(query.username).toUser()
	}
	
	fun User.toDBUser(): DBUser {
		//id will be generated
		return DBUser("", username, password)
	}
	
	fun DBUser.toUser(): User {
		return User (id, username, password )
	}
}