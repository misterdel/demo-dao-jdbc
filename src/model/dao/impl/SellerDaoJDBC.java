package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

				Departmant dep = new Departmant(rs.getInt("DepartamentId"), rs.getString("DepName"));

				Seller seller = new Seller(rs.getInt("Id"), rs.getString("Name"), rs.getString("Email"),
						rs.getDate("BirthDate"), rs.getDouble("BaseSalary"), dep);
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

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Connection getConn() {
		return conn;
	}
}
