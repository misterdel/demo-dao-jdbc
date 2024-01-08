package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Departmant;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
	
	/**	System.out.println("=== TEST 1: seller findById ===");		
		SellerDao sellerDao = DaoFactory.creatSellerDao();
		Seller seller = sellerDao.findById(3);
		System.out.println(seller.toString());
*/
		
		System.out.println("=== TEST 2: seller findByDepartament ===");		
		SellerDao sellerDao2 = DaoFactory.creatSellerDao();
		Departmant dep = new Departmant(2, null);
		
		List<Seller> sellers= sellerDao2.findByDepartament(dep);

		for (Seller seller2 : sellers) {
			System.out.println(seller2.toString());
		}
		
		
		
		
	}

}
