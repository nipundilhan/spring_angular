package com.example.springangular.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springangular.entity.highschool;
	
@Repository
public interface highschoolRepository  extends CrudRepository<highschool, Integer> {

}
