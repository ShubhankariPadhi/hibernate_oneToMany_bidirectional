package com.sbits.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sbits.demo.entity.Student;

public class PrimaryKeyDemo {

public static void main(String[] args) {
		
		
		
		//create sessionFactory
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			//create 3  student objects 	 
			System.out.println("creating 3 student object ");
			
			Student theStudent1=new Student(1,"sizu","v","v@gmail.com");
			Student theStudent2=new Student(2,"nobi","n","n@gmail.com");
			Student theStudent3=new Student(3,"sun","k","k@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object 
			System.out.println("saving the student");
			session.save(theStudent1);
			session.save(theStudent2);
			session.save(theStudent3);
			
			//commit the transaction
			session.getTransaction().commit();
			
		    
		}
		finally {
			factory.close();
		}
	}

}
