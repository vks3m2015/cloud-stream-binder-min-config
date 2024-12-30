package com.vik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class CloudStreamBinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudStreamBinderApplication.class, args);
	}


	@Bean
	public Supplier<String> producerBinding(){
        return () -> "new data";
	}

	@Bean
	public Function<String, String> processorBinding(){
		return s -> s + " :: " + System.currentTimeMillis();
	}

	@Bean
	public Consumer<String> consumerBinding(){
		return s -> System.out.println(" Data Consumed "+ s);
	}


}
