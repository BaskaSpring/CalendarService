package com.baska.CalendarService;

import com.baska.CalendarService.GRPC.CalendarServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

@EnableAutoConfiguration
@ComponentScan
@EnableScheduling
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
