package com.sbits.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sbits.demo.entity.Student;

public class CreateStuentDemo {

	public static void main(String[] args) {
		
		
		
		//create sessionFactory
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			//create a student object 
			System.out.println("creating new student object ");
			Student theStudent=new Student(122,"subhankari","padhi","s@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object 
			System.out.println("saving the student");
			session.save(theStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
		    
		}
		finally {
			factory.close();
		}
	}

}
