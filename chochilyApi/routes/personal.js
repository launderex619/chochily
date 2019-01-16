const express = require('express');
const router = express.Router();
const Personal = require('../models/Personal')
let PersonalHistory = require('../models/PersonalHistory')

const response = []

for (let i = 0; i < 10; i++) {
  PersonalHistory.Hora = new Date().getTime()-(i*1000)
   Personal.PersonalHistory.push(PersonalHistory)
  }

 for (let i = 0; i < 5; i++) {
  response.push(Personal)  
 }
/* GET Personal listing. */
router.get('/', function(req, res, next) {
    res.status(200).send(response);
  }
)

module.exports = router;
