package com.student.HBSecoundLevelCacheUsingQuery;

import org.hibernate.Query;
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
        
        Query q1 = session1.createQuery("from Student where sid=1");
        q1.setCacheable(true);
        s = (Student)q1.uniqueResult();
        System.out.println(s);
        
        
        session1.getTransaction().commit();
        session1.close();
        
        Session session2 = sf.openSession();
        session2.beginTransaction();
        
        Query q2 = session2.createQuery("from Student where sid=1");
        q2.setCacheable(true);
        s = (Student)q2.uniqueResult();
        System.out.println(s);
        
        session2.getTransaction().commit();
        session2.close();

    }

}
