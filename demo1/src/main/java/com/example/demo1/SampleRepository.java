package com.example.demo1;

import org.springframework.data.repository.CrudRepository;

public interface SampleRepository extends CrudRepository<SampleResponse,Integer> {
	
}
