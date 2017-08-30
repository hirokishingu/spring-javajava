package com.spring.data.jpa.example.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Department implements Serializable {

	@Id
	@GeneratedValue
	private Integer code;

	@Column(length = 20, nullable = false)
	private String name;

}
