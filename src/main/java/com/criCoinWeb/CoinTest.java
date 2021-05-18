package com.criCoinWeb;



public class CoinTest {

	public static void main(String[] args) {
		CoinDAO moneda1 = new CoinDAO();
		UserDAO tio = new UserDAO();
		ApiPojo apiPojo = new ApiPojo();
		
		ConexionAPI conexionApi = new ConexionAPI();
//		System.out.println(conexionApi.foo(tio.getUserIdByEmail("pepe@gmail.com")));
		System.out.println(conexionApi.infoMonedasUserById(1));
		
		
		
	}

}
