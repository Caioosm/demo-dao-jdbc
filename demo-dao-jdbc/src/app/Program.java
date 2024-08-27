package app;


import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
    public static void main(String[] args) throws Exception {
        
        Department obj = new Department(1, "books");

        
        SellerDao sellerDao = DaoFactory.creatSellerDao();
        
        Seller seller = sellerDao.findById(3);
        
        System.out.println(seller);
        
    }
}
