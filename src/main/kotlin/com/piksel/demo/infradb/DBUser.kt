package com.piksel.demo.infradb

import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity @Table(name = "users")
data class DBUser constructor (  @Id @GeneratedValue(strategy = IDENTITY)
								 var id: String,
								 var username: String,
								 var password: String)



