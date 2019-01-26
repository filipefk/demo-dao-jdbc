package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TESTE 1: Department findById ===");
		Department department = departmentDao.findById(3);
		System.out.println(department);
				
		System.out.println("\n=== TESTE 3: Department findAll ===");
		List<Department> departments = departmentDao.findAll();
		departments.forEach(System.out::println);
		
		System.out.println("\n=== TESTE 4: Department insert ===");
		department = new Department(null, "D2");
		departmentDao.insert(department);
		System.out.println("Inserted! New id = " + department.getId());
		
		System.out.println("\n=== TESTE 5: Department update ===");
		department = departmentDao.findById(1);
		department.setName("Toys");
		departmentDao.update(department);
		System.out.println("Update completed");
		
		System.out.println("\n=== TESTE 6: Department delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();

	}

}
