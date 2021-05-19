$('select').on('change', function () {
    $('#grafico').attr('src', "https://widget.coinlib.io/widget?type=chart&theme=light&coin_id=" + this.value + "&pref_coin_id=1505")
});



// BTC 859
// ETH 145
// BNB 1209
// ADA 122882
// DOGE 280
// DOLAR 1505