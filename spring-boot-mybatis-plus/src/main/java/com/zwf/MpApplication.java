package com.zwf;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

import com.zwf.datasource.DynamicDataSourceConfig;
/**
 * 
 * @author zwf
 *
 */
@SpringBootApplication()
@Import({DynamicDataSourceConfig.class})
@ServletComponentScan
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.zwf"})
//@MapperScan("com.zwf.modules.*")
public class MpApplication extends SpringBootServletInitializer{

	private static final Logger log = LoggerFactory.getLogger(MpApplication.class);

	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MpApplication.class);
		ApplicationContext appc =  app.run(args);
		Environment env = appc.getEnvironment();
		String ip = "localhost";
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
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
