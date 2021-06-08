package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Usuarios")
public class User {
	
	@Id
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String name;
	
	
	
	@Column(nullable = false)
	private String password;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Telephone> telephone = new ArrayList<Telephone>();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Telephone> getTelefone() {
		return telephone;
	}
	
	public void setTelefone(List<Telephone> telephone) {
		this.telephone = telephone;
	}
}