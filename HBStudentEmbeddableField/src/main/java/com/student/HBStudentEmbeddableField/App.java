package com.student.HBStudentEmbeddableField;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

class App 
{
    public static void main( String[] args )
    {
    	StudentName sn = new StudentName();
    	sn.setFname("Md");
    	sn.setLname("Babu");
    	sn.setMname("Mister");
    	
        Student stu = new Student();
        stu.setId(103);
        stu.setSname(sn);
        stu.setBranch("CS");
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(stu);
        tx.commit();
        
    }
}
