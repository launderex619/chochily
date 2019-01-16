const express = require('express');
const router = express.Router();
const ProductionCategories = require('../models/ProductionCategories')

router.get('/', function(req, res, next) {
    res.status(200).send(ProductionCategories);
  }
)

module.exports = router;
