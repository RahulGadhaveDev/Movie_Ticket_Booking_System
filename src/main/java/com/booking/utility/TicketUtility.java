package com.booking.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//utility class
public class TicketUtility {

	private TicketUtility() {

	}

	private static SessionFactory factory;

	public static SessionFactory getfactory() {

		if (factory == null) {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		return factory;
	}
}
