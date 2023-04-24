package com.kiran.emploeeDao;

public class EmploeeDaoFactory {
	public static EmploeeDao getInstance()
	{
		return new EmploeeDaoImpl();
	}
}
