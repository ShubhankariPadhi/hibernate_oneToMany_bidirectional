package com.sbits.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sbits.demo.entity.Instructor;
import com.sbits.demo.entity.InstructorDetail;
import com.sbits.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		
		
		//create sessionFactory
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
				           .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class).buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			
			Instructor tempInstructor=new Instructor("subhi","padhi","s@gmail");
			
			InstructorDetail tempInstructorDetail=new InstructorDetail("backtodance","d");
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			
			//start a transaction
			session.beginTransaction();
			
			
			//save the object 
			
			session.save(tempInstructor);
			
			//commit the transaction
			session.getTransaction().commit();
			
		    
		}
		finally {
			factory.close();
		}
	}

}
