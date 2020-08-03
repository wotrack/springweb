package com.cfe.springapi;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


import java.net.URI;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

@SpringBootApplication
public class Application {
	public static JedisPool pool;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}

	public static void onStart() {
        try {
    	    URI redisUri = new URI(System.getenv("localhost"));
            pool = new JedisPool(new JedisPoolConfig(),
                "localhost",6379, 
                Protocol.DEFAULT_TIMEOUT);

            System.out.println("Connection pool successfully initialized.");				
    	} catch (Exception e) {
    		System.out.println("Connection pool could  not be initialized."+ e);
    	    Application.pool = null;
    	}
    }

}