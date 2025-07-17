package Customer_Details;

import java.util.HashMap;

public class MyHandler implements RequestHandler<String, String>{
  
@Override
public String handleRequest(String input, Context context) {
Lambda Logger logger context.getLogger();
logger.log("Method Has been Called, Received Input:: "+input);
String response = null;
//String name = input.get("Name");
callDynamoDB(input, logger);
//HashMap<String, String> result = new HashMap<String, String>();
// result.put("NameResponse", name);
return response;
}

public void callDynamoDB (String customerId, Lambda Logger logger) {
// Set AWS region
Region region Region.US_WEST_2; // Change this to your AWS region
// Create DynamoDB client

DynamoDbClient dynamoDbClient DynamoDbClient.builder()

.region(region)

.credentialsProvider (ProfileCredentialsProvider.create()) // Uses AWS credentials from ~/.aws/credentials

.build();

String tableName = "Customer_Details"; // Change to your table name

String keyName = "CustomerId"; // Change to your primary key column name

String keyValue customerId; // Example key value

try {
Map<String, AttributeValue> key = new HashMap<>();

key.put(keyName, AttributeValue.builder().s(keyValue).build());

GetItemRequest request = GetItemRequest.builder()

.tableName(tableName)

.key(key)

.build();

GetItemResponse response = dynamoDbClient.getItem(request);

// Print retrieved values

if (!response.hasItem()) {

// System.out.println("No item found with key: " + keyValue);

logger.log("No item found with key::: "+keyValue);

} else {

Map<String, AttributeValue> item response.item();

// System.out.println("Retrieved item:");

logger.log("Retrieved item: :: ");

item.forEach((k, v) -> logger.log(k + ":" + v.s())); // Assuming String values

}

} catch (ResourceNotFoundException e) {

// System.err.println("Table not found: + e.getMessage());

logger.log("Table not found::: "+e.getMessage());

} catch (Exception e) {

logger.log("Error retriving data :: +e.getMessage());

} finally {

// Close the client

dynamoDbClient.close();

}

}

}
