package com.rmi.rmiclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import java.rmi.RemoteException;
import java.util.Scanner;

@SpringBootApplication
public class RmiclientApplication {

	@Bean
	RmiProxyFactoryBean  rmiProxy() {
		RmiProxyFactoryBean bean = new RmiProxyFactoryBean();
		bean.setServiceInterface(RMIService.class);
		bean.setServiceUrl("rmi://localhost:1099/SendMessageRMI");

		return bean;
	}
	public static void main(String[] args)  {

		RMIService rmiService = SpringApplication.run(RmiclientApplication.class, args) .getBean(RMIService.class);
		System.out.println("******************Client Side****************************");
		System.out.println("Your message is: " + rmiService.SayMessage("This is Cyril Owuor "));
		System.out.println("Enter a number");
		Scanner in = new Scanner(System.in);
		int numb = in.nextInt();
		System.out.println("Your entered number is: " + rmiService.Addition(numb));
	}

}
