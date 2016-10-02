package com.simscale.assignment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private String userName;
	private String firstName;
	private String lastName;
	private String cpf;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCpf() {
		return cpf == null ? "Sem CPF" : cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
