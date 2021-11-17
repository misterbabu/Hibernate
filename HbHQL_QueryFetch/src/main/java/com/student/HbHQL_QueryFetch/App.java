package com.student.HbHQL_QueryFetch;

import java.util.List;

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
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session1 = sf.openSession();
        session1.beginTransaction();
        
       /* Query q = session1.createQuery("from Student where marks>50");
        List<Student> students = q.list();
        for(Student s:students)
        {
        	System.out.println(s);
        }*/
        Query q = session1.createQuery("from Student where sid=7");
        Student s = (Student)q.uniqueResult();
        System.out.println(s);

        
        session1.getTransaction().commit();
    }

}
