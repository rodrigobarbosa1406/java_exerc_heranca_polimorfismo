package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		System.out.println();
		
		for (int i=1; i<=n; i++) {
			System.out.println("PRODUCT #" + i + " DATA:");
			
			System.out.print("Common, used or imported (c/u/i)? ");
			char typeProduct = sc.next().charAt(0);
			sc.nextLine();
			
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			switch (typeProduct) {
			case 'i':
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				
				list.add(new ImportedProduct(name, price, customsFee));
				break;
			case 'u':
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				sc.nextLine();
				
				list.add(new UsedProduct(name, price, manufactureDate));
				break;
			case 'c':
				list.add(new Product(name, price));
				break;
			}
			
			System.out.println();
		}
		
		System.out.println("PRICE TAGS:");
		
		for (Product product : list) {
			System.out.println(product.priceTag());
		}
		
		sc.close();
	}

}