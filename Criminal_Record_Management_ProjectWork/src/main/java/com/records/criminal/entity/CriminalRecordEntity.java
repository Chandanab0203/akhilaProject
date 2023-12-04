package com.records.criminal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="criminal_record")
public class CriminalRecordEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="fileNo")
	private int fileNo;
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	@Column(name="gender")
	private String gender;
	@Column(name="nationality")
	private String nationality;
	@Column(name="age")
	private int age;
	@Column(name="offense")
	private String offense;
	@Column(name="bailStatus")
	private String bailStatus;
	@Column(name="jailTerm")
	private String jailTerm;
}
