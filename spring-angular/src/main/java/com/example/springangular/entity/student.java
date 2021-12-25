package com.example.springangular.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity // This tells Hibernate to make a table out of this class
public class student {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  
  public student() {
	  
  }

  public student(Integer grade, String firstname, String lastname, String contactvalue) {
	super();
	this.grade = grade;
	this.firstname = firstname;
	this.lastname = lastname;
	this.contactvalue = contactvalue;
}

private Integer grade;
  
  private String firstname;

  private String lastname;
  
  private String contactvalue;
  
  @ManyToOne
  @JoinColumn(name = "highschoolid")
  private highschool highscl;
  
//  @OneToMany
//  @JoinColumn(name = "studentid") // we need to duplicate the physical information
//  private List<coursestudent> studentcources;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
  
  public Integer getGrade() {
	 return grade;
  }

  public void setGrade(Integer grade) {
	 this.grade = grade;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String fname) {
    this.firstname = fname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lname) {
    this.lastname = lname;
  }

public String getContactvalue() {
	return contactvalue;
}

public void setContactvalue(String contactvalue) {
	this.contactvalue = contactvalue;
}
}
