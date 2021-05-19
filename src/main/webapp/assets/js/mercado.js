let selector = document.getElementById("inputGroupSelect01");

function cambioGrafica() {
    $('#grafico').attr('src', 'https://widget.coinlib.io/widget?type=chart&theme=light&coin_id=145&pref_coin_id=1505')
}

selector.addEventListener('change', cambioGrafica);


// BTC 859
// ETH 145
// BNB 1209
// ADA 122882
// DOGE 280
// DOLAR 1505