package app;


import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
// import model.entities.Department;
import model.entities.Seller;

public class Program {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.creatDepartmentDao();
        
        System.out.println("=== TEST 1: seller findByID: ===");     
        SellerDao sellerDao = DaoFactory.creatSellerDao();
        
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findByDepartment: ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);     
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: seller findAll: ===");
        list = sellerDao.findAll();     
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 4: seller Insert: ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 3000.00, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! new ID = " + newSeller.getId());
        
        System.out.println("\n=== TEST 5: seller Update: ===");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update completed!");

        // System.out.println("\n=== TEST 6: seller Delete: ===");
        // System.out.print("Enter ID for delete test: ");
        // int id = sc.nextInt();
        // sellerDao.deleteById(id);
        // System.out.println("Delete completed!");
        
        
        System.out.println("\n=== TEST 1: Department Insert: ===");
        Department newDepartment = new Department(null, "D3");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New Department: " + newDepartment.getName());
        
		System.out.println("\n=== TEST 4: update =======");
		Department dep2 = departmentDao.findById(6);
		dep2.setName("Food");
		departmentDao.update(dep2);
		System.out.println("Update completed");
        
        System.out.println("\n=== TEST 3: Department FindById: ===");
        Department dep = departmentDao.findById(1);
		System.out.println(dep);

        System.out.println("\n=== TEST 4: findAll =======");
		List<Department> list2 = departmentDao.findAll();
		for (Department d : list2) {
			System.out.println(d);
		}

        System.out.println("\n=== TEST 5: delete =======");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");

        
        sc.close();

    }
}
