package com.zwf.springbootdemo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;


@SpringBootApplication
public class SpringBootDemoApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringBootDemoApplication.class);

	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringBootDemoApplication.class);
		ApplicationContext appc =  app.run(args);
		Environment env = appc.getEnvironment();
		String ip = "localhost";
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("\n----------------------------------------------------------\n\t" +
				"Application '{}' is running! Access URLs:\n\t" +
				"Local: \t\thttp://{}:{}\n\t" +
				"----------------------------------------------------------",
				env.getProperty("spring.profiles.active"),ip,
				env.getProperty("server.port"));
		log.info("程序启动完成!");
	}

}
