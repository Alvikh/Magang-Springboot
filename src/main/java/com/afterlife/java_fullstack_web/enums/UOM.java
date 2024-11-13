package com.afterlife.java_fullstack_web.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UOM {

	PCS("Pcs"),
	
	KG("Kg"),
	
	GRAM("Gr"),
	
	ROLL("Roll"),
	
	PAIL("Pail");
	
	public final String tampilkanUOM;
}
