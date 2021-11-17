package com.student.HbHQL_Query;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
	public static void main( String[] args )
    {
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session1 = sf.openSession();
        session1.beginTransaction();
        
        Random r = new Random();
        for(int i=1;i<=50;i++)
        {
        	Student s = new Student();
        	s.setSid(i);
        	s.setsName("Name "+i);
        	s.setMarks(r.nextInt(100));
        	session1.save(s);
        }

        
        session1.getTransaction().commit();
    }

}