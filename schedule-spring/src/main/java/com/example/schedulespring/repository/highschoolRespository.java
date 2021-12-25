package com.example.schedulespring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.schedulespring.entity.highschool;



@Repository
public interface highschoolRespository   extends CrudRepository<highschool, Integer> {


}

