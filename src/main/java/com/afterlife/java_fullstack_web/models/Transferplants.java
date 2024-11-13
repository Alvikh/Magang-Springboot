package com.afterlife.java_fullstack_web.models;

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
@Table(name = "m_transferplants")
public class Transferplants {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String picIncharge;
	
	private String documentNo;
	
	private String quantity;
	
	@Enumerated(EnumType.STRING)
	private UOM uom;
	
	private String place;
	
	private String sendingDate;
}
