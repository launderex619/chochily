var express = require('express');
var router = express.Router();
var debug = require('debug')
debug = new debug("api/")

/* GET home page. */
router.get('/', function(req, res, next) {
  res.status(200).send({'index': "/",  status: 'UP' });
});

module.exports = router;
