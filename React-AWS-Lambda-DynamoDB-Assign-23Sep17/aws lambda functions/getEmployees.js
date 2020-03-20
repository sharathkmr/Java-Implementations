// create an IAM Lambda role with access to dynamodb
// Launch Lambda in the same region as your dynamodb region

console.log('Loading event');
var AWS = require('aws-sdk');
var dynamodb = new AWS.DynamoDB({apiVersion: '2012-08-10'});

exports.handler = (event, context, callback) => {
    // TODO implement
    var tableName = "Employees";
    console.log('tablename: '+tableName);
    dynamodb.scan({
        TableName : tableName,
        Limit : 40
    }, function(err, data) {
        if (err) {
            context.done('error','reading dynamodb failed: '+err);
        }
        
        console.log(data);
        var res = [];
        for (var i in data.Items) {
            i = data.Items[i];
            
            var emp = {id:i.id.N, name:i.name.S, salary:i.salary.N};
            console.log(emp);
            res.push(emp);
          //  context.done(null, "Ciao!");
        }
        context.succeed(res);
    });
 //   callback(null, 'Hello from Lambda');
};