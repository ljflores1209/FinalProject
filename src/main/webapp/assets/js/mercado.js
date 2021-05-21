$('select').on('change', function() {
	$('#grafico').attr('src', "https://widget.coinlib.io/widget?type=chart&theme=light&coin_id=" + this.value + "&pref_coin_id=1505")
	/*let coinval= $('#par').attr('src', "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&ids=bitcoin&order=market_cap_desc&per_page=100&page=1&sparkline=false")
		let coinval= $('#par').attr('src', "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&ids=bitcoin&order=market_cap_desc&per_page=100&page=1&sparkline=false")
	let cambio= $("#apuesta").val();*/
	$('#conversion').val("https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&ids=bitcoin&order=market_cap_desc&per_page=100&page=1&sparkline=false");
});





let secval = $("#sonante").html();

let inival = $("#apuesta").val();
$("#apuesta").change(function() {
/*if ($("#sonante").html()>0){*/
	let cantidad = $("#apuesta").val();
	$("#sonante").html(secval - cantidad);

}

);

$("#apuesta").keyup(function() {
	let cantidad = $("#apuesta").val();
	$("#sonante").html(secval - cantidad);


});


const form = document.getElementById('idForm');

function validateValorCompra() {
    var acumErrores = 0;

    form.classList.remove('is-invalid');

    var apuesta = document.forms['myForm']['apuesta'];


    if(apuesta.value < 0 ) {
        apuesta.classList.add("is-invalid");
		document.getElementById("apuesta").textContent = "No puede ser menor a 0";
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
    validateValorCompra();
}, true);



// BTC 859
// ETH 145
// BNB 1209
// ADA 122882
// DOGE 280
// DOLAR 1505