package com.criCoinWeb;



public class CoinTest {

	public static void main(String[] args) {
//		CoinDAO moneda1 = new CoinDAO();
//		UserPojo aaa=new UserPojo(0,"papaapap", "12345");
//		WalletDAO  modelo2 = new WalletDAO();
		UserDAO tio = new UserDAO();
		
		System.out.println(tio.comprobarLogin("luis@gmail.com", "789"));
		//System.out.println(tio.comprobarEmail("ppp@gmail.com"));
		//System.out.println(tio.getUserIdByPass("123"));
		//System.out.println(tio.comprobarEmail("jose@gmail.com"));
		//System.out.println(tio.getUserIdByEmail("jose@gmail.com"));
		//*System.out.println(tio.pruebaVariableSession());
		//System.out.println(moneda1.getCoin(2));
		//System.out.println(moneda1.getCoin(3));
//		System.out.println(modelo2.getWallet(5));
//		System.out.println(modelo2.getWallet(6));
//		System.out.println(modelo2.getWalletUser(1));
//		System.out.println(tio.getUser(10));
//		
//		
	}

}
