package model.dao;

import java.util.List;

import model.entities.Departmant;

public interface DepartmentDao {
	void insert(Departmant obj);

	void update(Departmant obj);

	void deleteById(Integer id);

	Departmant findById(Integer id);

	List<Departmant> findAll();
}
