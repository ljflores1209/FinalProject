package com.criCoinWeb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class ConexionAPI {	
	public ApiPojo foo() {
		CoinDAO moneda1 = new CoinDAO();
		UserDAO tio = new UserDAO();
		ApiPojo apiInfo = new ApiPojo();
		for(int i = 0; i<moneda1.getCoinsByIdUser(1).size();i++) {
			System.out.println(moneda1.getCoinsByIdUser(1).get(i).getName());
					
			try {
			String resultado=peticionHttpGet("https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&ids="+moneda1.getCoinsByIdUser(1).get(i).getName()+"&order=market_cap_desc&per_page=100&page=1&sparkline=false");
			
			JSONArray json = new JSONArray(resultado);
			System.out.println(json);
			
			for(int j=0; j < json.length(); j++)   
			{  
			JSONObject object = json.getJSONObject(j);  
			
			apiInfo = new ApiPojo(object.getString("name"), object.getString("symbol"),object.getInt("current_price"));

			}

			}catch(Exception ex) {
				System.out.println(ex);
			}
			
		}
		return apiInfo;
	}
	
	public static String peticionHttpGet(String urlParaVisitar) throws Exception {
		  // Esto es lo que vamos a devolver
		  StringBuilder resultado = new StringBuilder();
		  // Crear un objeto de tipo URL
		  URL url = new URL(urlParaVisitar);

		  // Abrir la conexión e indicar que será de tipo GET
		  HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		  conexion.setRequestMethod("GET");
		  // Búferes para leer
		  BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		  String linea;
		  // Mientras el BufferedReader se pueda leer, agregar contenido a resultado
		  while ((linea = rd.readLine()) != null) {
		    resultado.append(linea);
		  }
		  // Cerrar el BufferedReader
		  rd.close();
		  // Regresar resultado, pero como cadena, no como StringBuilde
		 		  
		  return resultado.toString();
		  
		  
		}
	

}
