/**
 * 
 */
package com.rcp.mgnt.model;

import java.io.Serializable;

public class RcpInfoTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1826822339144723999L;

	private String id;
	private String name;
	private String ingredient_1;
	private String ingredient_2;
	private String ingredient_3;
	private String ingredient_4;

	public RcpInfoTO() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIngredient_1() {
		return ingredient_1;
	}

	public void setIngredient_1(String ingredient_1) {
		this.ingredient_1 = ingredient_1;
	}

	public String getIngredient_2() {
		return ingredient_2;
	}

	public void setIngredient_2(String ingredient_2) {
		this.ingredient_2 = ingredient_2;
	}

	public String getIngredient_3() {
		return ingredient_3;
	}

	public void setIngredient_3(String ingredient_3) {
		this.ingredient_3 = ingredient_3;
	}

	public String getIngredient_4() {
		return ingredient_4;
	}

	public void setIngredient_4(String ingredient_4) {
		this.ingredient_4 = ingredient_4;
	}

}
