package com.aniketsenvasy.sessionerppos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	
	@Column(name="full_name")
	private String fullName;
	
	@Column(name="email") 
	private String email;
	
	@Column(name="mobileNumber")
	private double mobileNumber;
	
	@Column(name="gender")
	private String gender;

	@Column(name="dateOfBirth") 
	private String dateOfBirth;

}





