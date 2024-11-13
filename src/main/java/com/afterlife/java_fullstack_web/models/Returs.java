package com.afterlife.java_fullstack_web.models;

import com.afterlife.java_fullstack_web.enums.Country;
import com.afterlife.java_fullstack_web.enums.UOM;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "m_returs")
public class Returs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 50)
	private String codeGoods;
	
	@Column(length = 50)
	private String nameGoods;
	
	private String description;
	
	private String amountRetur;
	
	private String productionDate;
	
	@Enumerated(EnumType.STRING)
	private UOM uom;
	
	@Enumerated(EnumType.STRING)
	private Country country;
	
	private String returDate;
}
