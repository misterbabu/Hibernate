package com.student.HBStudentDetails;



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
        Student stu = new Student();
        stu.setId(101);
        stu.setName("Naresh");
        stu.setBranch("CS");
        
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(stu);
        tx.commit();
        
    }
}
