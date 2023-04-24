package com.kiran.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbUtility {
	private static SessionFactory factory;
	
	public static SessionFactory getFactory()
	{
		if(factory==null)
		{
			return new Configuration().configure("hibernate.kiran.xml").buildSessionFactory();
		}
		else {
			return factory;
		}
	}
	
	
}
