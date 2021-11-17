package com.student.HBMappingOneToOne;


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
    	lap.setLid(105);
    	lap.setlName("Hp");
    	  
        Student stu = new Student();
        stu.setSid(5);
        stu.setsName("Suresh");
        stu.setMarks(60);
        stu.setLaptop(lap);
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        session.beginTransaction();
        
        session.save(lap);
        session.save(stu);
        
        session.getTransaction().commit();

    }
}

