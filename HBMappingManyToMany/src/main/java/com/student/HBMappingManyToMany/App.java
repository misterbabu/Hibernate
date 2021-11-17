package com.student.HBMappingManyToMany;

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
    	Laptop lap = new Laptop();
    	lap.setLid(103);
    	lap.setlName("Hp");
    	  
        Student stu = new Student();
        stu.setSid(3);
        stu.setsName("Suresh");
        stu.setMarks(60);
        stu.getLaptop().add(lap);
        lap.getStudent().add(stu);
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        session.save(lap);
        session.save(stu);
        
        tx.commit();

    }
}
