package com.spring.data.jpa.example.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Authentication implements Serializable {

	@Id
	private String id;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private java.sql.Date validDate;

	@OneToOne(optional = false)
	@JoinColumn(name = "employeeNo", referencedColumnName = "no")
	private Employee employee;
}
