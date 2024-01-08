package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Departmant;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

	private Connection conn;

	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = getConn().prepareStatement(
					"select seller.*, departament.\"Name\" as DepName from seller INNER JOIN departament ON seller.\"DepartamentId\" = departament.\"Id\" WHERE seller.\"Id\"=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {

				Departmant dep = instantiateDepartament(rs);
				Seller seller = instantiateSeller(rs, dep);

				return seller;
			}

			return null;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
			DB.closeConnection();
		}

	}

	private Seller instantiateSeller(ResultSet rs, Departmant dep) throws SQLException {
		Seller seller = new Seller(rs.getInt("Id"), rs.getString("Name"), rs.getString("Email"),
				rs.getDate("BirthDate"), rs.getDouble("BaseSalary"), dep);
		return seller;
	}

	private Departmant instantiateDepartament(ResultSet rs) throws SQLException {
		Departmant dep = new Departmant(rs.getInt("DepartamentId"), rs.getString("DepName"));
		return dep;
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Connection getConn() {
		return conn;
	}

	@Override
	public List<Seller> findByDepartament(Departmant departamentId) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Seller> sellers= null;
		try {
			ps = getConn().prepareStatement(
					"select seller.*, departament.\"Name\" as DepName from seller INNER JOIN departament ON seller.\"DepartamentId\" = departament.\"Id\" WHERE seller.\"DepartamentId\"=? order by seller.\"Name\"");
			ps.setInt(1, departamentId.getId());
			rs = ps.executeQuery();

			sellers = new ArrayList<Seller>();
			Map<Integer, Departmant> map = new HashMap<Integer, Departmant>();

			while (rs.next()) {

				Departmant dep = map.get(rs.getInt("DepartamentId"));
				
				if (dep == null) {
					dep = instantiateDepartament(rs);
					map.put(rs.getInt("DepartamentId"), dep);
				}
				
				Seller seller = instantiateSeller(rs, dep);

				sellers.add(seller);

			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
			DB.closeConnection();
		}

		return sellers;
	}
}
