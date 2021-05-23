//------------------grafica que cambia en funcion a mi seleccion en el selector------------------------------
$('select').on('change', function() {
	 var id = $(this).find('option:selected').attr('id');
	 
	 
	$('#grafico').attr('src', "https://widget.coinlib.io/widget?type=chart&theme=light&coin_id=" + id + "&pref_coin_id=1505")
});

//-------------------------------------------------------zona compra de monedas--------------------------------------------

//----------------------------cojo el precio de la moneda del fetch, calculo la cantidad / precio y la imprimo , imprimo el precio de la moneda en dolares

let trasport = 0;// precio de la moneda seleccionada


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


//---------------resta de mi capital_total la cantidad que introduzco en el valor de compra y la cantidad de moneda que compro on change

let conversion=$("#conversion").val();
let secval = $("#sonante").html();

let inival = $("#apuesta").val();

$("#apuesta").change(function() {
	let cantidad = $("#apuesta").val();
	$("#sonante").html(secval - cantidad);
	let cartera = $('#cartera').html();
	
	$("#conversion").val(cantidad / trasport);//cantidad de moneda
	

	
    });
//---------------resta de mi capital_total la cantidad que introduzco en el valor de compra y la cantidad de moneda que compro on keyup
$("#apuesta").keyup(function() {
	let cantidad = $("#apuesta").val();
	$("#sonante").html(secval - cantidad);
	
	$("#conversion").val(cantidad / trasport);//cantidad de moneda
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

//---------------------------------------fin zona de compra---------------------------------------------------------------------------------------------

//---------------------------------------inicio zona de venta-------------------------------------------------------------------------------------------

let trasporte = 0;// precio de la moneda seleccionada
let trasporteValor = 0; // cantidad valor incial de la moneda que selecciono

document.getElementById('inputGroupSelect02').addEventListener('change', cambiarVenta)
function cambiarVenta () {

let moneda = this.value; //nombre de la moneda seleccionada

let valor = valorCoin(moneda); //declaro valor para usar la funcion que tengo en el script del jsp
trasporteValor = valor;
document.getElementById('carteraVenta').innerHTML = valor ; //imprimo la cantidad de monedas que tengo
document.getElementById('coinVenta').innerHTML =  ' ' + moneda + 's';

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
      trasporte = precio;
      const cantidad = parseFloat(document.getElementById('apuestaVenta').value)//cantidad de monedas que quiero comprar
     console.log("cantidad"+cantidad);
      document.getElementById('conversionVenta').value = valor * cantidad;
      console.log(document.getElementById('conversionVenta').value = valor * cantidad);
      document.getElementById('precioCoin').innerHTML = " 1 " + moneda + " = " + precio + " USD"
      
      
      
    })
    .catch(function (err) {
      console.log('Error: ', err)
    })
}

//---------------on change resta de mi coins que tengo la cantidad que introduzco en el valor de venta y la cantidad de moneda que vendo

let conversionVenta=$("#conversionVenta").val();
let secvalVenta =$('#carteraVenta').html();;

let inivalVenta = $("#apuestaVenta").val();

$("#apuestaVenta").change(function() {
	let cantidadVenta = $("#apuestaVenta").val();
	$("#carteraVenta").html(trasporteValor - cantidadVenta);
	
	 secvalVenta = $('#carteraVenta').html();
	
	$("#conversionVenta").val(secvalVenta * trasporte);//cantidad de moneda
	

	
    });
    
    
    //---------------resta de mi capital_total la cantidad que introduzco en el valor de compra y la cantidad de moneda que compro on keyup
$("#apuestaVenta").keyup(function() {
	let cantidadVenta = $("#apuestaVenta").val();
	$("#carteraVenta").html(secvalVenta - cantidadVenta);
	
	$("#conversion").val(secvalVenta * trasporte);//cantidad de moneda
});
    

//---------------------------------------fin zona de venta----------------------------------------------------------------------------------------------

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