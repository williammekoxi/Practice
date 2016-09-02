var express = require('express');
var router = express.Router();
var config = require('../config.json');

/* GET one file. */
router.get('/*', function(req, res, next) {
	var relatedPath = decodeURI(req.path);
	var path = config.filePath + relatedPath

	var fs = require('fs');
	fs.exists(path, function (exists) {
		if (exists) {
			fs.stat(path, function (err, stats) {
				if (err) {
					res.status(500).send('internal error. ' + err);
				} else if (stats.isFile()) {
					fs.readFile(path, function (err, data) {
						res.type('text').send(data.toString());
					});
				} else if (stats.isDirectory()) {
					fs.readdir(path, function (err, files) {
						var output = new Array();
						//var e;


						files.forEach(function (file) {



							var stats = fs.statSync(file);
							if (stats.isFile()) {
								output.push({ name: file, a: 'f' });
							} else if (stats.isDirectory()) {
								output.push({ name: file, a: 'd' });
							}

							/*
							fs.stat(file, function (err, stats) {
								if (err) {
									e = err;
								} else if (stats.isFile()) {
									output.push({ name: file, a: 'f' });
								} else if (stats.isDirectory()) {
									output.push({ name: file, a: 'd' });
								}
							});
							*/
						});

						es.json(output);

						/*
						if (e) {
							res.status(500).send('internal error. ' + e);
						} else {
							res.json(output);
						}
						*/
					});
				}
			});
		} else {
			res.status(404).send('"' + relatedPath + '" not found.')
		}
	});
});

module.exports = router;



const Promise = require('bluebird');

fs.statAsnyc().then(function(stats){}).error(function(){

})