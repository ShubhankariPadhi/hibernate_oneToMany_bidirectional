package com.sbits.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sbits.demo.entity.Instructor;
import com.sbits.demo.entity.InstructorDetail;


public class DeleteDemo {

	public static void main(String[] args) {
		
		
		
		//create sessionFactory
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
				           .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class).buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			
			
			
			//start a transaction
			session.beginTransaction();
			
			//get instructor object by primary key
			int id=1;
			Instructor tempInstructor=session.get(Instructor.class,id); // if the id exists then data will be retrieved otherwise returns null
			System.out.println("the instructor is  "+tempInstructor);
			
			// delete the instructor object
			  if(tempInstructor!=null) {
				System.out.println("deleting "+ tempInstructor);
				
				session.delete(tempInstructor);//as it is cascaded it will delete the foreign key related table data also
				
			}
			
			//commit the transaction
			session.getTransaction().commit();
			
		    
		}
		finally {
			factory.close();
		}
	}

}
