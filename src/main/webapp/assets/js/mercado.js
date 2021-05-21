$('select').on('change', function() {
	$('#grafico').attr('src', "https://widget.coinlib.io/widget?type=chart&theme=light&coin_id=" + this.value + "&pref_coin_id=1505")
	$('#par').attr('src', "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&ids="
		+ this.id +
		"&order=market_cap_desc&per_page=100&page=1&sparkline=false")
});



/*let apuesta = document.getElementById("apuesta");
apuesta.addEventListener('change', function(){
	alert("Hola que ase");
});*/

let secval = $("#sonante").html();

let inival = $("#apuesta").val();
$("#apuesta").change(function() {
	let cantidad = $("#apuesta").val();
	$("#sonante").html(secval - cantidad);


});

//campo oculto
let inivalh = $("#apuestah").val();
$("#apuestah").val("cambiado").triggerHandler('change'); //cambiando el valor
$("#apuestah").on("change", function() {
	alert('campo oculto cambiado');
}).triggerHandler('change');

// BTC 859
// ETH 145
// BNB 1209
// ADA 122882
// DOGE 280
// DOLAR 1505