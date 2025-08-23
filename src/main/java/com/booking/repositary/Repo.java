package com.booking.repositary;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.booking.entity.UserDetail;
import com.booking.utility.TicketUtility;

public class Repo {

	Scanner sc = new Scanner(System.in);

//post tiket the database
	public void bookTicket() {
		UserDetail user = new UserDetail();

		System.out.println("enter movie for book");
		String movie = sc.next();
		user.setMovieName(movie);

		System.out.println("Enter your name ");
		String name = sc.next();
		user.setCustomerName(name);

		System.out.println("Enter show time ");
		String show = sc.next();
		user.setShowTime(show);

		System.out.println("enter Seat booked");
		int book = sc.nextInt();
		user.setSeatsBooked(book);

		SessionFactory factory = TicketUtility.getfactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.persist(user);

		transaction.commit();
		session.close();

	}

	//get all student
	public void getAll() {
		SessionFactory factory = TicketUtility.getfactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		List<UserDetail> user = session.createQuery("select u from UserDetail u", UserDetail.class).getResultList();

		user.stream().forEach(k -> System.out.println(k));

		transaction.commit();
		session.close();
	}
//update the data
	public void updateNumber() {
		SessionFactory factory = TicketUtility.getfactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("enter user Id ");
		int id = sc.nextInt();
		UserDetail user = session.find(UserDetail.class, id);

		System.out.println("Enter a seat book updeted");
		int seat = sc.nextInt();
		user.setSeatsBooked(seat);

		transaction.commit();
		session.close();
	}

	public void deleteUser() {
		SessionFactory factory = TicketUtility.getfactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("Enter User name ");
		String customerName = sc.next();

		List<UserDetail> user = session
				.createQuery("select u from UserDetail u where u.customerName = :customerName", UserDetail.class)
				.setParameter("customerName", customerName).getResultList();

		for (UserDetail u : user) {

			session.remove(u);
		}
		transaction.commit();
		session.close();

	}

}
