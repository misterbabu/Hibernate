package com.student.HBSecondLevelCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
	public static void main( String[] args )
    {
    	  
        Student s = null;
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session1 = sf.openSession();
        session1.beginTransaction();
        
        s = (Student)session1.get(Student.class, 1);
        System.out.println(s);
        
        
        session1.getTransaction().commit();
        session1.close();
        
        Session session2 = sf.openSession();
        session2.beginTransaction();
        
        s = (Student)session2.get(Student.class, 1);
        System.out.println(s);
        
        session2.getTransaction().commit();
        session2.close();

    }

}