package com.baska.CalendarService;

import com.baska.CalendarService.Grpc.CalendarServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.IOException;

@SpringBootApplication
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
