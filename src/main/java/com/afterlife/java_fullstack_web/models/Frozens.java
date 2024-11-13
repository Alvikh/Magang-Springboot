package com.afterlife.java_fullstack_web.models;

import com.afterlife.java_fullstack_web.enums.Country;
import com.afterlife.java_fullstack_web.enums.UOM;
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
@Table(name = "m_frozens")
public class Frozens {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String code;
	
	private String description;
	
	@Enumerated(EnumType.STRING)
	private UOM uom;
	
	@Enumerated(EnumType.STRING)
	private Country country;
	
	private String dateIn;

}
