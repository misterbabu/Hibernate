package com.student.HBStudentDetailsFetch;



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
    	  Student stu = null; //we dont create object becz we will get object in stu = (Student)session.get(Student.class, 101);
        //Student stu = new Student();
        //stu.setId(103);
        //stu.setName("Vinay");
        //stu.setBranch("CS");
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        stu = (Student)session.get(Student.class, 101);
       // session.save(stu);
        tx.commit();
        System.out.println(stu);
        
    }
}
