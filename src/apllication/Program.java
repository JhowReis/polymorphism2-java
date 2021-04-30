package apllication;

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
		// TODO Auto-generated method stub

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> list = new ArrayList<>();

		System.out.println("Enter the number of product");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Product data # " + i + ":");
			System.out.print("Common, Used or Imported? (c/u/i)");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if (ch == 'i') {
				System.out.print("Custom fee:");
				double customFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customFee));
				
			}
			else if(ch == 'u') {
				System.out.print("manufacturated date (DD/MM/YYYY)");
				Date manufacturedDate = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, manufacturedDate));
			}
			else {
				list.add(new Product(name, price));
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for(Product pro : list) {
			System.out.println(pro.priceTag());
			
		}
		 
		
		
		
		

		sc.close();
	}

}
