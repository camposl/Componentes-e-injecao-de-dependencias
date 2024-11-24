package com.lucas.desafio_01_devsuperior;

import com.lucas.desafio_01_devsuperior.entities.Order;
import com.lucas.desafio_01_devsuperior.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class Desafio01DevsuperiorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Desafio01DevsuperiorApplication.class, args);
	}
	
	@Autowired
	private OrderService orderService;

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println();
		char choice = 's';

		while (choice != 'n'){

			System.out.print("Código do pedido: ");
			int code = sc.nextInt();
			System.out.print("Valor basico: ");
			double basic = sc.nextDouble();
			System.out.print("Porcentagem de desconto: ");
			double discount = sc.nextDouble();

			Order order = new Order(code, basic, discount);
			System.out.println();

			System.out.println("Pedido código " + code);
			System.out.printf("Valor total: R$ %.2f", orderService.total(order));
			System.out.println();
			System.out.println();

			System.out.println("Você deseja continuar consultando o pedido? (s/n)");
			choice = sc.next().charAt(0);
			System.out.println();

		}

		System.out.println("*********************************************************************************************");
		System.out.println("*                                     FIM DO PROGRAMA                                       *");
		System.out.println("*********************************************************************************************");

		sc.close();

	}
}
