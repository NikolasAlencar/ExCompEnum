package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("\n Email: ");
		String email = sc.nextLine();
		System.out.print("\n Birth Date (DD/MM/YYYY): ");
		Date birthdate = sdf.parse(sc.next());
		Client client = new Client(name, email, birthdate);
		System.out.println("Enter order data:");
		System.out.println("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		
		
		Order order = new Order(new Date(), status, client);
		
		System.out.println("How many items to this order? ");
		int n = sc.nextInt();
		for (int i=1; i<=n; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.println("Product name: ");
			String nameProduct = sc.next();
			System.out.println("Product price: ");
			double priceProduct = sc.nextDouble();
			System.out.println("Quantity: ");
			int quantity = sc.nextInt();
			
			Product product = new Product(nameProduct, priceProduct);
			
			OrderItem products = new OrderItem(quantity, priceProduct, product);
			
			order.addItem(products);
		}	
		
		System.out.println(order);
			
		sc.close();
		}

	}