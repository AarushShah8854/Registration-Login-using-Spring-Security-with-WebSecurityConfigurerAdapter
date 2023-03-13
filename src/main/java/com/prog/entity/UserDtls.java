package com.prog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="USER_DTLS")
@Data
public class UserDtls {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "Name")
	private String fullname;
	private String gender;
	private String dob;
	private String address;
	private String email;
	private String password;
	private String role;

}
