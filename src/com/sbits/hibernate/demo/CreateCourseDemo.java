package com.sbits.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sbits.demo.entity.Course;
import com.sbits.demo.entity.Instructor;
import com.sbits.demo.entity.InstructorDetail;


public class CreateCourseDemo {

	public static void main(String[] args) {
		
		
		
		//create sessionFactory
		SessionFactory factory=new Configuration().configure()
				           .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class).addAnnotatedClass(Course.class).buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
		int theId=1;
		Instructor tempInstructor=session.get(Instructor.class,theId);
		
		Course tempcourse1=new Course("math ");
		Course tempcourse2=new Course("vocabs");
		Course tempcourse3=new Course("science");
		Course tempcourse4=new Course("IT");
		
		
		tempInstructor.add(tempcourse1);
		tempInstructor.add(tempcourse2);
		tempInstructor.add(tempcourse3);
		tempInstructor.add(tempcourse4);
		
		
		
		session.save(tempcourse1);
		session.save(tempcourse2);
		session.save(tempcourse3);
		session.save(tempcourse4);
		
		
		
		
			//commit the transaction
			session.getTransaction().commit();
			
		    
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
