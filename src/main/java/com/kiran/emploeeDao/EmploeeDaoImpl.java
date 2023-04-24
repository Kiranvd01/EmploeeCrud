package com.kiran.emploeeDao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.kiran.model.Emploee;
import com.kiran.util.DbUtility;

public class EmploeeDaoImpl implements EmploeeDao{
	DbUtility utility;
	
	
	public EmploeeDaoImpl() {
		utility=new DbUtility();
	}


	@Override
	public int saveEmploee(Emploee e) {
		SessionFactory factory= utility.getFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		try {
		session.save(e);
		tx.commit();
		
		factory.close();
		session.close();
		return 1;
		}catch(Exception r)
		{
			
		factory.close();
		session.close();
		return 0;
		}
	}


	@Override
	public int deleteEmloee(Emploee id) {
		SessionFactory factory=utility.getFactory();
		Session session =factory.openSession();
		Transaction tx=session.beginTransaction();
		try {
		session.delete(id);
		tx.commit();
		factory.close();
		session.close();
		return 1;
		}catch(Exception e)
		{
			factory.close();
			session.close();
			return 0;
		}
	}


	@Override
	public int updateEmploee(Emploee e) {
		SessionFactory factory=DbUtility.getFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		try {
		session.update(e);
		tx.commit();
		factory.close();
		session.close();
		return 1;
		}catch(Exception t)
		{
			factory.close();
			session.close();
			return 0;
		}
	}


	@Override
	public Emploee readEmploee(int id) {
		SessionFactory factory=utility.getFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		try {
		Emploee e=session.get(Emploee.class, id);
		factory.close();
		session.close();
		return e;
		}catch(Exception t)
		{
			System.out.println(t);
			factory.close();
			session.close();
			return null;
		}
	}


	@Override
	public List<Emploee> readAllEmploee() {
		SessionFactory factory=utility.getFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		try {
		String sql="from Emploee e";
		Query<Emploee> query=session.createQuery(sql);
		List<Emploee> list=query.list();
		factory.close();
		session.close();
		return list;
		}catch(Exception t)
		{
			factory.close();
			session.close();
			return null;
		}
	}


}
