package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Seller implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String email;
	private Date birthDate;
	private Double baseSalary;
	private Departmant departmant;

	public Seller() {
	}

	public Seller(Integer id, String name, String email, Date birthDate, Double baseSalary, Departmant departmant) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.baseSalary = baseSalary;
		this.departmant = departmant;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the baseSalary
	 */
	public Double getBaseSalary() {
		return baseSalary;
	}

	/**
	 * @param baseSalary the baseSalary to set
	 */
	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	/**
	 * @return the departmant
	 */
	public Departmant getDepartmant() {
		return departmant;
	}

	/**
	 * @param departmant the departmant to set
	 */
	public void setDepartmant(Departmant departmant) {
		this.departmant = departmant;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seller other = (Seller) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Seller \nId: " + id + "\nName: " + name + "\nEmail: " + email + "\nBirthDate: " + birthDate + "\nBaseSalary: "
				+ baseSalary + "\nDepartmant: " + departmant + "\n";
	}

}
