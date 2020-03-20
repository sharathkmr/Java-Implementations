// create an IAM Lambda role with access to dynamodb
// Launch Lambda in the same region as your dynamodb region

console.log('Loading event');
var AWS = require('aws-sdk');
var dynamodb = new AWS.DynamoDB({apiVersion: '2012-08-10'});

exports.handler = (event, context, callback) => {
    // TODO implement
    console.log(JSON.stringify(event, null, '  '));
    dynamodb.listTables(function(err, data) {
      console.log(JSON.stringify(data, null, '  '));
    });
    var tableName = "Employees";
    
	var success = {
        statusCode: '200',
        body: {success:'insertion success'},
        headers: {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*',
        }
    };
    var item = {
        "id": {
            "N":event.id
        },
        "name": {
            "S":event.name
        },
        "salary": {
            "N":event.salary
        }
    };
    console.log("Item:\n", item);
    dynamodb.putItem({
        "TableName": tableName,
        "Item" : item
    }, function(err, data) {
        if (err) {
            console.log(err);
            context.done('error','putting item into dynamodb failed: '+err);
        }
        else {
            console.log('great success: '+JSON.stringify(data, null, '  '));
         //   context.done('K THX BY');
            context.succeed(success);
        }
    });
//    callback(null, 'Data insertion');
};