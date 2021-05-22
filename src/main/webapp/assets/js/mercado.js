$('select').on('change', function() {
	 var id = $(this).find('option:selected').attr('id');
	 
	 $('#id_moneda').val(id);
	$('#grafico').attr('src', "https://widget.coinlib.io/widget?type=chart&theme=light&coin_id=" + id + "&pref_coin_id=1505")
});


let trasport = 0;

document.getElementById('inputGroupSelect01').addEventListener('change', cambiar)
function cambiar () {

let moneda = this.value;
  fetch("https://api.coingecko.com/api/v3/simple/price?ids=" + this.value + "&vs_currencies=usd")
    .then(function (response) { // Si tengo respuesta
      return response.text() // El html de la página me lo pasas al siguiente then
    })
    .then(function (html) { // Dentro de html yo tengo la respuesta de la página
      console.log(html)
      const objeto = JSON.parse(html)
      console.log(objeto)
      
      let precio = Object.values(objeto);
      precio = precio[0].usd;
      trasport = precio;
      const cantidad = parseFloat(document.getElementById('apuesta').value).toFixed(2)
     
      console.log(cantidad)
      
      document.getElementById('conversion').value = cantidad / precio 
      document.getElementById('cartera').innerHTML = " 1 " + moneda + " = " + precio + " USD"
      
    })
    .catch(function (err) {
      console.log('Error: ', err)
    })
}



let conversion=$("#conversion").val();
let secval = $("#sonante").html();

let inival = $("#apuesta").val();

$("#apuesta").change(function() {
	let cantidad = $("#apuesta").val();
	$("#sonante").html(secval - cantidad);
	let cartera = $('#cartera').html();
	$("#conversion").val(cantidad / trasport);
	

	
    });

$("#apuesta").keyup(function() {
	let cantidad = $("#apuesta").val();
	$("#sonante").html(secval - cantidad);
	$("#conversion").val(cantidad / trasport);
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