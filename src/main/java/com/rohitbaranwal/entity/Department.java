package com.rohitbaranwal.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@	DynamoDBDocument //this tells that the class here will not be treated as entity but as json data in employee table
public class Department {
	
	@DynamoDBAttribute
	private String departmentName;
	@DynamoDBAttribute
	private String departmentCode;

}
