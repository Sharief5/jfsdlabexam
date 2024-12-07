package com.klef.jfsd.examm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        insertDepartment(sessionFactory);

        
		/* deleteDepartmentById(sessionFactory, 1); */

        sessionFactory.close();
    }

    private static void insertDepartment(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Department dept = new Department("CSE", "Building A", "Dr. Reddy");
        session.save(dept);

        transaction.commit();
        session.close();
        System.out.println("Department inserted successfully!");
    }

    private static void deleteDepartmentById(SessionFactory sessionFactory, int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "delete from Department where deptId = :id";
        session.createQuery(hql).setParameter("id", id).executeUpdate();

        transaction.commit();
        session.close();
        System.out.println("Department deleted successfully!");
    }
}
