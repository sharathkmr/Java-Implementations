// create an IAM Lambda role with access to dynamodb
// Launch Lambda in the same region as your dynamodb region

console.log('Loading event');
var AWS = require('aws-sdk');
var dynamodb = new AWS.DynamoDB({apiVersion: '2012-08-10'});

exports.handler = (event, context, callback) => {
    // TODO implement
    var params = {
        TableName: "Employee",
        Key: {
            "id": {
                "N": event.id
            }
        }
    };
    console.log('params '+params);
     dynamodb.deleteItem(params, function(err, data) {
       if (err) {
           console.log(err, err.stack); // an error occurred
       }
       else {
           console.log(data);   // successful response
           context.success({success:"Deleted successfully"});
       }
     });
    // callback(null, 'Hello from Lambda');
};