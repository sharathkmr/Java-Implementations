// create an IAM Lambda role with access to dynamodb
// Launch Lambda in the same region as your dynamodb region

console.log('Loading event');
var AWS = require('aws-sdk');
var dynamodb = new AWS.DynamoDB({apiVersion: '2012-08-10'});

exports.handler = (event, context, callback) => {
    // TODO implement
    console.log('Incoming: ', event);
    // console.log(event.name);
    // console.log(event.id);
    // console.log(event.salary);
    
    var tableName = "Employee";
    var params = {
            TableName: table,
        Key:{
            "id": {
                "N": event.id
            }
        },
        ExpressionAttributeNames: {
        "#EMPNAME": "name", 
        "#EMPSAL": "salary"
        },
        ExpressionAttributeValues: {
                ":nameVal": { "S": event.name },
                ":salaryVal": { "N": event.salary }
        },
        UpdateExpression: "SET #EMPNAME = :nameVal, #EMPSAL = :salaryVal",
        
        ReturnValues: "UPDATED_NEW"
    };
    
    console.log("params: %j", params);
    console.log('updating the values..');
    
    
    dynamodb.updateItem(params, function(err, data) {
        if (err) {
            console.log(err, err.stack); // an error occurred
        } else {
            console.log(data);
            context.success({Update:"Success"});
        }
    });
     
    // callback(null, 'Hello from Lambda');
};