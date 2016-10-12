var express = require('express');
var router = express.Router();
var config = require('../config.json');
var Promise = require('bluebird');
var fs = Promise.promisifyAll(require('fs'));
var path = require('path');

/* GET one file. */
router.get('/*', function(req, res, next) {
	var relatedPath = decodeURI(req.path);
	var absolutePath = config.filePath + relatedPath

	fs.existsAsync(absolutePath).then(function () {
		res.status(404).send('"' + relatedPath + '" not found.')
	}, function () {
		fs.statAsync(absolutePath).then(function (stats) {
			if (stats.isFile()) {
				fs.readFileAsync(absolutePath).then(function (data) {
					res.type('text').send(data.toString());
				});
			} else if (stats.isDirectory()) {
				fs.readdirAsync(absolutePath).then(function (files) {
					var output = new Array();

					files.forEach(function (file) {
						var fileStats = fs.statSync(path.join(absolutePath, file));
						if (fileStats.isFile()) {
							output.push({ p: path.join(relatedPath, file), a: 'f' });
						} else if (fileStats.isDirectory) {
							output.push({ p: path.join(relatedPath, file), a: 'd' });
						}
					});

					res.json(output);
				});
			}
		});
	}).catch(function (e) {
		res.status(500).send('internal error. ' + e);
	});

});

module.exports = router;



