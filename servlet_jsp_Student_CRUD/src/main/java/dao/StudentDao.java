package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Student;

public class StudentDao {

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Nag");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public Student saveStudent(Student student) {
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		return student;
	}
	public Student fetchByPhone(long phone) {
		Query query=entityManager.createQuery("select s from Student s where s.studentPhone=?1");
		query.setParameter(1, phone);
		try {
			Student student=(Student) query.getSingleResult();
			return student;
		}
		catch(Exception e) {
			return null;
		}
		}
	
	public Student fetchById(int id) {
		Student student=entityManager.find(Student.class, id);
		if(student!=null) {
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
			return student;
		}
		else {
			return null;
		}
	}
	public Student updateStudent(Student student) {
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
		return student;
	}
	public boolean deleteById(int id) {
		Student student=entityManager.find(Student.class, id);
		if(student!=null) {
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
			return true;
		}
		return false;
		
	}
}
