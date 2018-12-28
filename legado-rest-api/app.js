var express = require('express');

var app = express();
app.get('/', function(req, res) {
  res.send('ok!');
});

var config = require('./data.json');
app.get('/lancamentos', function(req, res) {
  res.send(config);
});

app.listen(3001, function() {
  console.log('App listening on port 3001!');
});