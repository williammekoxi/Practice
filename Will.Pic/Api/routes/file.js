var express = require('express');
var router = express.Router();
var config = require('../config.json');

/* GET one file. */
router.get('/*', function(req, res, next) {
  res.send(config.filePath + req.path);
});

module.exports = router;

