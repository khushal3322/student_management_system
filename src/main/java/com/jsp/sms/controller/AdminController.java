package com.jsp.sms.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.jsp.sms.model.Admin;
import com.jsp.sms.model.Student;

public class AdminController {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("psql");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		public Admin fetchAdmin() {
			return entityManager.find(Admin.class, 1);
		}

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
		
		public Student featchstudent(int studentid) {
			return entityManager.find(Student.class, studentid);
		}

		public List<Student> fetchAllStudent() {
			String query = "SELECT s FROM Student s;";
			TypedQuery<Student> typedQuery = entityManager.createQuery(query, Student.class);
			List<Student> students = typedQuery.getResultList();
			return students;
		}

		public boolean addStudent(Student student,Admin admin) {
			if (student != null) {
				entityTransaction.begin();
				entityManager.persist(student);
				entityManager.merge(admin);
				entityTransaction.commit();
				return true;
			}
			return false;
		}

		public Student updateStudent(Student student) {
			if (student != null) {
				entityTransaction.begin();
				Student updatedStudent = entityManager.merge(student);
				entityTransaction.commit();
				return updatedStudent;
			} else {
				return null;
			}
		}

		public boolean deleteStudent(Student student) {
			if (student != null) {
				entityTransaction.begin();
				entityManager.remove(student);
				entityTransaction.commit();
				return true;
			}
			return false;
		}

		public boolean DeletepraticularStudent(int studenttoDelete) {
			
			Admin admin = entityManager.find(Admin.class, 1);
			if (admin!=null) {
				List<Student> students = admin.getStudents();
				
				if (students==null) {
					
					//no accounts
					return false;
					
					
				} else {
					Student studenttoremove =null;
					for (Student student : students) {
						if (student.getStudentId()==studenttoDelete) {
							studenttoremove=student;
							break;
						}
					}
					if (studenttoremove!=null) {
						entityTransaction.begin();
						students.remove(studenttoremove);
						entityTransaction.commit();
						
						entityTransaction.begin();
						entityManager.remove(studenttoremove);
						entityTransaction.commit();
						return true;
					} else {
						
						//not this account
						return false;
					}
				}
			}
			//no bank
				return false;
			
			
		}
}
