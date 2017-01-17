package com.gzw;

import com.gzw.Interceptor.MyServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BsApplication {


	public static void main(String[] args) {
		SpringApplication.run(BsApplication.class, args);
	}
}
