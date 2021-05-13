<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <h1>Hoy el bitcoin esta <span id="cotizacion"></span></h1>
    <script>
       fetch('https://api.coingecko.com/api/v3/coins/markets?vs_currency=eur&ids=bitcoin%2C%20btc&order=market_cap_desc&per_page=100&page=1&sparkline=false')
  .then(response => response.json())
  .then(function (data){
      
    let price=data[0].current_price
    console.log(price);
 
  })
    </script>
</body>
</html>
