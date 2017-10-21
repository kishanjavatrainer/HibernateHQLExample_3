package com.infotech.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.infotech.util.HibernateUtil;

public class HQLHibernate5ClientTest {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		updateEmployeeEmailById(sf);
		//deleteEmployeeById(sf);
	}

	private static void deleteEmployeeById(SessionFactory sf) {
		int empId=2;
		try(Session session = sf.openSession() ) {
			
			String HQL = "DELETE FROM Employee WHERE employeeId=:empId";
			
			Query query = session.createQuery(HQL);
			query.setParameter("empId", empId);
			
			session.beginTransaction();
			int executeUpdate = query.executeUpdate();
			session.getTransaction().commit();
			if(executeUpdate>0)
				System.out.println("Employee is deleted..");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	private static void updateEmployeeEmailById(SessionFactory sf) {
		int empId=2;
		String newEmail="martin.b2007@gmail.com";
		try(Session session = sf.openSession() ) {
			
			String HQL = "UPDATE Employee set email=:newEmail WHERE employeeId=:empId";
			
			Query query = session.createQuery(HQL);
			query.setParameter("newEmail", newEmail);
			query.setParameter("empId", empId);
			
			session.beginTransaction();
			int executeUpdate = query.executeUpdate();
			session.getTransaction().commit();
			if(executeUpdate>0)
				System.out.println("Employee email is updated..");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
