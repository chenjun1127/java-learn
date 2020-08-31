package com.example.mybaties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

 

@MapperScan("com.example.mybaties.mapper")
@SpringBootApplication
public class MybatiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatiesApplication.class, args);
	}

}


 