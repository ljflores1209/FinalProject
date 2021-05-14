/**
 * 
 */


fetch('https://api.coingecko.com/api/v3/coins/markets?vs_currency=eur&ids=bitcoin%2C%20btc&order=market_cap_desc&per_page=100&page=1&sparkline=false')
	.then(response => response.json())
	.then(function(data) {

		let price = data[0].current_price
		let symbol = data[0].symbol
		let name = data[0].name
		let percentage = data[0].price_change_percentage_24h

		let temporizador = setTimeout(saludo(), 1000)

		function saludo() {
			console.log("hola");
			document.getElementsByClassName("price")[0].innerHTML = price
			document.getElementsByClassName("siglas")[0].innerHTML = symbol
			document.getElementsByClassName("name")[0].innerHTML = name
			document.getElementsByClassName("percentage")[0].innerHTML = percentage
			
		}

	})
	
	
	
	fetch('https://api.coingecko.com/api/v3/coins/markets?vs_currency=eur&ids=ethereum&order=market_cap_desc&per_page=100&page=1&sparkline=true')
	.then(response => response.json())
	.then(function(data) {

		let price = data[0].current_price
		let symbol = data[0].symbol
		let name = data[0].name
		let percentage = data[0].price_change_percentage_24h

		let temporizador = setTimeout(saludo, 1000)
		
		function saludo() {
			 console.log("hola");
			document.getElementsByClassName("price")[1].innerHTML = price
			document.getElementsByClassName("siglas")[1].innerHTML = symbol
			document.getElementsByClassName("name")[1].innerHTML = name
			document.getElementsByClassName("percentage")[1].innerHTML = percentage
			let temporizador = setTimeout(saludo, 1000)
		}
		
		})
		
		fetch('https://api.coingecko.com/api/v3/coins/markets?vs_currency=eur&ids=binancecoin&order=market_cap_desc&per_page=100&page=1&sparkline=true')
	.then(response => response.json())
	.then(function(data) {

		let price = data[0].current_price
		let symbol = data[0].symbol
		let name = data[0].name
		let percentage = data[0].price_change_percentage_24h

		let temporizador = setTimeout(saludo, 1000)
		
		function saludo() {
			 console.log("hola");
			document.getElementsByClassName("price")[2].innerHTML = price
			document.getElementsByClassName("siglas")[2].innerHTML = symbol
			document.getElementsByClassName("name")[2].innerHTML = name
			document.getElementsByClassName("percentage")[2].innerHTML = percentage
			let temporizador = setTimeout(saludo, 1000)
		}
		
		})
		
		fetch('https://api.coingecko.com/api/v3/coins/markets?vs_currency=eur&ids=dogecoin&order=market_cap_desc&per_page=100&page=1&sparkline=true')
	.then(response => response.json())
	.then(function(data) {

		let price = data[0].current_price
		let symbol = data[0].symbol
		let name = data[0].name
		let percentage = data[0].price_change_percentage_24h

		let temporizador = setTimeout(saludo, 1000)
		
		function saludo() {
			 console.log("hola");
			document.getElementsByClassName("price")[3].innerHTML = price
			document.getElementsByClassName("siglas")[3].innerHTML = symbol
			document.getElementsByClassName("name")[3].innerHTML = name
			document.getElementsByClassName("percentage")[3].innerHTML = percentage
			let temporizador = setTimeout(saludo, 1000)
		}
		
		})