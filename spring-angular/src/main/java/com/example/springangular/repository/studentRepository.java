package com.example.springangular.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springangular.entity.student;


@Repository
public interface studentRepository  extends CrudRepository<student, Integer> {
	
	List<student> findAll();
	
	@Query(value ="select * from student where student.highschoolid = ?1 ", nativeQuery = true)
	List<student> findBySchlId(int id);

}
