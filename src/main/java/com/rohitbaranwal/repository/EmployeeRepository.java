package com.rohitbaranwal.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.rohitbaranwal.entity.Employee;

@Repository
public class EmployeeRepository {

	@Autowired
	DynamoDBMapper dbMapper;

	public ResponseEntity<Employee> save(Employee emp)
	{
		try {
			dbMapper.save(emp);
			return new ResponseEntity<Employee>(HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<Employee>(HttpStatus.FORBIDDEN);
		}
	}

	public ResponseEntity<Employee> getEmployeeById(String empId)
	{
		try {
			Employee employee=dbMapper.load(Employee.class,empId);
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<Employee>delete(String empId)
	{
		try {
			Employee employee=dbMapper.load(Employee.class,empId);
			dbMapper.delete(employee);
			return new ResponseEntity<Employee>(HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		}
	}
	public ResponseEntity<Employee> update(Employee emp,String empId)
	{
		try {
			dbMapper.save(emp, 
					new DynamoDBSaveExpression().
					withExpectedEntry("employeeId",
							new ExpectedAttributeValue(
									new AttributeValue().withS(empId))
							)
					);
			return new ResponseEntity<Employee>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		}
		
	}

}
