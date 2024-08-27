package app;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
    public static void main(String[] args) throws Exception {
        
        Department obj = new Department(1, "books");

        Seller seller = new Seller(21, "bob", "bob@gmail.com", new Date(), 3000.00, obj);

        SellerDao sellerDao = DaoFactory.creatSellerDao();
        
        System.out.println(seller);
        
    }
}
