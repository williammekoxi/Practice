var mongoClient = require('mongodb').MongoClient;

var url = "mongodb://localhost:27017/Practice";

mongoClient.connect(url, function(err, db) {
	db.listCollections().toArray(function(err, items) {
		for (var i in items) {
			console.log(items[i]);
		}
	});

	var collection = db.collection("Log201604");
	collection.insert({ Firstname: "William", Lastname: "Huang"}, function(err, result) {
		console.log("err: %s", err);
		console.log("result: %s", result);
		db.close();
	});
})