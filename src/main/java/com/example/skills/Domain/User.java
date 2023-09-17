package com.example.skills.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private String password;
	
	// Enum으로 객체가 생성되지만, DB에 들어갈때는 varchar로 바뀜.
	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private Roletype roletype;
	
	public User() {
		
	}

	// getter-setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Roletype getRoletype() {
		return roletype;
	}

	public void setRoletype(Roletype roletype) {
		this.roletype = roletype;
	}
	
}
