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

/**
 * Main application class for the Payment Gateway System.
 * Bootstraps the application and includes a runner that fetches and logs
 * the account balance from the MTN MoMo API on startup.
 */
@SpringBootApplication
@EnableFeignClients
@Slf4j
@RequiredArgsConstructor
public class PaymentGatewaySystemApplication {

	private final MomoClient momo;

	/**
	 * ApplicationRunner bean that runs code after the Spring Boot application has started.
	 * Fetches the account balance from the MoMo API and logs it.
	 * @return an {@link ApplicationRunner} instance that performs the task
	 */
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
