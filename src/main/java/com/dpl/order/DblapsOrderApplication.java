package com.dpl.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
@ServletComponentScan
@SpringBootApplication
public class DblapsOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DblapsOrderApplication.class, args);
	}

}
