package com.sbits.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sbits.demo.entity.Course;
import com.sbits.demo.entity.Instructor;
import com.sbits.demo.entity.InstructorDetail;


public class GetInstructorDetailCourses {

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
		
		
		System.out.println("instructor:" +tempInstructor);
		
		System.out.println("courses"+ tempInstructor.getCourses());
		
		
			//commit the transaction
			session.getTransaction().commit();
			
		    
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
