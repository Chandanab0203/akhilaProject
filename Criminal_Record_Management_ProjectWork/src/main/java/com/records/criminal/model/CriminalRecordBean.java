package com.records.criminal.model;

import lombok.Data;

@Data
public class CriminalRecordBean {

	private int fileNo;
	private String firstName;
	private String lastName;
	private String gender;
	private String nationality;
	private int age;
	private String offense;
	private String bailStatus;
	private String jailTerm;
}
