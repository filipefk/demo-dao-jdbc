package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TESTE 1: Seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TESTE 2: Seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> sellers = sellerDao.findByDepartment(department);
		sellers.forEach(System.out::println);
		
		System.out.println("\n=== TESTE 3: Seller findAll ===");
		sellers = sellerDao.findAll();
		sellers.forEach(System.out::println);
		
		System.out.println("\n=== TESTE 4: Seller insert ===");
		seller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(seller);
		System.out.println("Inserted! New id = " + seller.getId());
		
		System.out.println("\n=== TESTE 5: Seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		seller.setEmail("martha@gmail.com");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n=== TESTE 6: Seller delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}

}
