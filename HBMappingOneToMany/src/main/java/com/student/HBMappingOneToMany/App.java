package com.student.HBMappingOneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

class App 
{
    public static void main( String[] args )
    {
    	Laptop lap = new Laptop();
    	lap.setLid(104);
    	lap.setlName("Dell");
    	  
        Student stu = new Student();
        stu.setSid(4);
        stu.setsName("Ram");
        stu.setMarks(50);
        stu.getLaptop().add(lap);
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        session.beginTransaction();
        
        session.save(stu);
        session.save(lap);
        
        session.getTransaction().commit();

    }
}