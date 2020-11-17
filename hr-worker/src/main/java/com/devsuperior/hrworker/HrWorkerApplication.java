package com.devsuperior.hrworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HrWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrWorkerApplication.class, args);
	}
//	insert into tb_worker (name, daily_Income) values ('Bob', 200.0);
//	insert into tb_worker (name, daily_Income) values ('Maria', 300.0);
//	insert into tb_worker (name, daily_Income) values ('Alex', 250.0);
}
