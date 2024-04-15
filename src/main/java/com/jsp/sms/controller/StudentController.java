package com.jsp.sms.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.jsp.sms.model.Student;

public class StudentController {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("psql");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public Student fetchStudent(String username) {
		int id = getStudentId(username);
		return entityManager.find(Student.class, id);
	}
	
	public int getStudentId(String username) {
		int id=0;
		List<Student> allStudent = fetchAllStudent();
		for (Student student : allStudent) {
			if (username.equals(student.getUsername())) {
				return student.getStudentId();
			}
			break;
		}
		return id;
	}
	
	public List<Student> fetchAllStudent() {
		String query = "SELECT s FROM Student s";
		TypedQuery<Student> typedQuery = entityManager.createQuery(query, Student.class);
		List<Student> students = typedQuery.getResultList();
		return students;
	}
	
	public Student updateStudent(Student student) {
		if (student!=null) {
			entityTransaction.begin();
			Student updatedStudent = entityManager.merge(student);
			entityTransaction.commit();
			return updatedStudent;
		}else {
			return null;
		}
	}
	public boolean updateStudent1(Student student) {
		if (student!=null) {
			entityTransaction.begin();
			Student updatedStudent = entityManager.merge(student);
			entityTransaction.commit();
			return true;
		}
			return false;
		
	}

}
