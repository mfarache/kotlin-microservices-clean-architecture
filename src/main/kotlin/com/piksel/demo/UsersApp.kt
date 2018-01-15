package com.piksel.demo

import com.piksel.demo.infradb.DBContext
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Import
import com.piksel.demo.boundaries.impl.UseCaseContext
import com.piksel.demo.rest.RestContext
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.boot.CommandLineRunner
import com.piksel.demo.infradb.UserRepository
import com.piksel.demo.infradb.DBUser

@SpringBootApplication
open class UsersApp  {
	private val log =  LoggerFactory.getLogger(UsersApp::class.java)

	@Bean
	open fun init(repository: UserRepository) = CommandLineRunner {
			// save a couple of customers
			repository.save(DBUser("1", "John", "Passwd1"))
			repository.save(DBUser("2", "Mike", "Passwd2"))

			log.info("Users added:")
			log.info("-------------------------------")
			repository.findAll().forEach { log.info(it.toString()) }
			log.info("")
	}
	

}

fun main(args: Array<String>) {
    SpringApplication.run(UsersApp::class.java, *args)
}