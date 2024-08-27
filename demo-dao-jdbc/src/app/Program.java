package app;


import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
// import model.entities.Department;
import model.entities.Seller;

public class Program {
    public static void main(String[] args) throws Exception {
        
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
        
    }
}
