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

		//Validacion email

		const form = document.getElementById('idForm');

function validateIndexEmail() {
    var acumErrores = 0;

    form.classList.remove('is-invalid');

    var inputEmail = document.forms['myForm']['inputEmail'];

    var inputEmail = document.getElementById('inputEmail');

    if(inputEmail.value == '') {
        inputEmail.classList.add("is-invalid");
		document.getElementById("errorEmail").textContent = "Campo obligatorio";
        acumErrores ++;
    } else if(!validar_email(inputEmail.value)){
		inputEmail.classList.add("is-invalid");
		document.getElementById("errorEmail").textContent = "No cumple el formato";
		acumErrores ++;
    }

    if (acumErrores > 0){
        return false;
    }else{
		return true;
	}
}

form.addEventListener('blur', (event) => {
	console.log(event);
	if(event.target.value!='') event.target.classList.remove('is-invalid');
    validateIndexEmail();
}, false);

function validar_email(email) {
	var regex = /^([ña-zA-Z0-9_\.\-])+\@(([ña-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	return regex.test(email) ? true : false;
}