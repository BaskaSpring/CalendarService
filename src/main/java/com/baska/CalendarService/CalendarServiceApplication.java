package com.baska.CalendarService;

import com.baska.CalendarService.Grpc.CalendarServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import java.io.IOException;


@EnableAutoConfiguration
@ComponentScan
public class CalendarServiceApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(CalendarServiceApplication.class, args);
		Server server = ServerBuilder.forPort(8069)
				.addService(ApplicationContextHolder.getContext().getBean(CalendarServiceImpl.class))
				.build();
		server.start();
		server.awaitTermination();
	}

}
