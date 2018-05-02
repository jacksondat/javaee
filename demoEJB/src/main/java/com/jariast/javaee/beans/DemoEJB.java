package com.jariast.javaee.beans;

import javax.ejb.Stateless;

@Stateless
public class DemoEJB {
	
	public int sumar(int a, int b) {
		return a + b;
	}

}
