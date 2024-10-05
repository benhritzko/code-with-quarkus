package org.acme

import io.quarkus.runtime.Startup
import software.amazon.awssdk.services.dynamodb.DynamoDbClient

@Startup
class Clients {
    val dynamoDbClient = DynamoDbClient.create()
}