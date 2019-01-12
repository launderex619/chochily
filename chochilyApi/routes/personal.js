var express = require('express');
var router = express.Router();

const Personal = {
  Id: "userid:",
  ImageSrc: "https://vozdelsur.com.mx/wp-content/uploads/2018/09/amlo-bb.jpg",
  Nombre: "Andres Manuel Lopez bebe",
  Codigo: "12535425552",
  Correo: "fresita@chochily.com",
  Tipo: "user", //admin, user
  PersonalHistory: [],
}

const PersonalHistory = {
  Id: "personalhistoryid",
  Propietario: Personal.Id,
  Accion: "Entrada",
  Hora: new Date(),
}

const response = []

for (let i = 0; i < 10; i++) {
  Personal.PersonalHistory.push(PersonalHistory)
}

for (let i = 0; i < 10; i++) {
  response.push(Personal)  
}


/* GET Personal listing. */
router.get('/', function(req, res, next) {
  res.status(200).send(response);
});

module.exports = router;
