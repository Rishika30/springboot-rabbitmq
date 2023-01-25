package com.example.demo1;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SampleResponse")
public class SampleResponse {
	@Id
     Integer id;
     String name;
     Integer age;
     String email;
    
    public SampleResponse() {
    	
    }
    public SampleResponse(Integer id, String name, Integer age, String email) {
    	this.id= id;
    	this.name= name;
    	this.age= age;
    	this.email=email;
    }
    
    public Integer getId() {
    	return id;
    }
    
    public String getName() {
    	return name;
    }
    
    public Integer getAge() {
    	return age;
    }
    
    public String getEmail() {
    	return email;
    }

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
}
