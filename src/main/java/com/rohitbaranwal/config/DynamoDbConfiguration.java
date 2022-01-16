package com.rohitbaranwal.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamoDbConfiguration {
	
	@Bean
	public DynamoDBMapper dynamoDBMapper()
	{
		return new DynamoDBMapper(buildAmazonDynamoDb());
	}

	private AmazonDynamoDB buildAmazonDynamoDb() {
		
		return AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(
						new AwsClientBuilder.EndpointConfiguration(
								"https://dynamodb.ap-south-1.amazonaws.com", //service end point is aws service which we are using  service.region.amazonaws.com
								"ap-south-1")
						)
				.withCredentials(
						 new AWSStaticCredentialsProvider(
								new BasicAWSCredentials("AKIA5GPSZ6BB6QLWHEP4","kIAAUkGxZIFpmRrqzsBkFg1GBoyusTa0153RqI5x")
								)
						 ).build();
	}

}
