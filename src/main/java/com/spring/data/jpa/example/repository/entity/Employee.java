package com.spring.data.jpa.example.repository.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Employee {
	private static final long serialVersionUID = 1L;

	public static enum Sex {
		male, female
	}

	@Id
	@GeneratedValue
	private Integer no;

	@Column(length = 20, nullable = false)
	private String firstName;

	@Column(length = 20, nullable = false)
	private String lastName;

	@Column(length = 10)
	@Enumerated(EnumType.STRING)
	private Sex sex;

	private java.sql.Date birthday;

	@Column(unique = true)
	private String mailAddress;

	@Version
	private Integer version;

	@ManyToOne(optional = false)
	@JoinColumn(name = "departmentCode")
	private Department department;

	@OneToOne(mappedBy = "employee", cascade = CascadeType.REMOVE)
	private Authentication authentication;

}
