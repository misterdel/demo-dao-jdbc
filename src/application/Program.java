package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		/**Departmant dp = new Departmant(1,"Teste");
		System.out.println(dp.toString());	
		
		Seller s = new Seller(21, "bob", "bob@gmail.com", new Date(), 1000.0, dp);
		
		System.out.println(s.toString());
*/
		
		SellerDao sellerDao = DaoFactory.creatSellerDao();
		Seller seller = sellerDao.findById(3);
		System.out.println(seller.toString());

	}

}
