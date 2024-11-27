package Bashiru.com.Payment.Gateway.System;


import Bashiru.com.Payment.Gateway.System.Clients.MomoClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import lombok.var;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableFeignClients
@Slf4j
@RequiredArgsConstructor
public class PaymentGatewaySystemApplication {

	private final MomoClient momo;

	@Bean
	ApplicationRunner applicationRunner()
	{
		return args->
		{
			var response = momo.balance();
			log.info("AccountBalance from Momo-Api: {} ",response);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(PaymentGatewaySystemApplication.class, args);
		//System.out.println("Hello world");
	}

}
