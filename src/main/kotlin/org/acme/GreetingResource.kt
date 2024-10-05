package org.acme

import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import software.amazon.awssdk.services.dynamodb.model.AttributeValue
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest
import software.amazon.awssdk.services.dynamodb.model.UpdateItemRequest

@Path("/hello")
class GreetingResource {

    @Inject
    lateinit var clients: Clients

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun hello() {

        clients.dynamoDbClient
            .putItem(PutItemRequest.builder()
                .tableName("samwell-application-table")
                .item(mapOf(
                    Pair("username", AttributeValue.fromS("chungus")),
                    Pair("SK1", AttributeValue.fromS("chungus also")),
                    Pair("data", AttributeValue.fromS("my data"))
                ))
                .build()
            )
    }


}