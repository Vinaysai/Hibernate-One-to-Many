package com.onetomany.all.OneToMany.mian;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.onetomany.all.OneToMany.Customer;
import com.onetomany.all.OneToMany.Vendor;

public class DBContriol {

	public static SessionFactory getsession() {

		Configuration con = new Configuration().configure();
		SessionFactory sf = con.buildSessionFactory();
		return sf;

	}

	// Load Method.
	public static void load() {
		Session s = getsession().openSession();

		int id = 28;

		Customer c = (Customer) s.load(Customer.class, new Integer(id));
		System.out.println("Details of Custome:" + c.getId() + "Name::" + c.getName());

		int id1 = 37;

		Customer c1 = (Customer) s.load(Customer.class, new Integer(id1));
		System.out.println("Details of Custome:" + c1.getId() + "Name::" + c1.getName());

	}

	// Get Method.
	public static void get() {
		Session s = getsession().openSession();

		int id = 28;

		Customer c = (Customer) s.get(Customer.class, new Integer(id));
		System.out.println("Details of Custome:" + c.getId() + "Name::" + c.getName());

		int id1 = 37;

		Customer c1 = (Customer) s.get(Customer.class, new Integer(id1));
		System.out.println("Details of Custome:" + c1.getId() + "Name:::::" + c1.getName());

	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = getsession().openSession();

		Vendor v = new Vendor();

		v.setVid(2837);
		v.setVname("Sai");

		Customer c1 = new Customer();
		c1.setId(28);
		c1.setName("Vinay");

		Customer c2 = new Customer();
		c2.setId(37);
		c2.setName("sai");

		@SuppressWarnings("rawtypes")
		Set s = new HashSet();

		s.add(c1);
		s.add(c2);

		v.setChild(s);

		Transaction tx = session.beginTransaction();
		session.save(v);
		tx.commit();

		Scanner sc = new Scanner(System.in);
		System.out.println("Ender your Choice:::::::::");

		sc.nextInt();
		int a = sc.nextInt();
		switch (a) {
		case 1:
			System.out.println("Your Load Method Details are::");

			load();
			break;

		case 2:
			System.out.println("Your Get Method Details are::");

			get();
			break;
		default:
			System.out.println("Invalid option");
			break;

		}
		session.close();
		sc.close();
		System.out.println("One to Many Annotatios Done...!!!!!!");
		getsession().close();

	}

}
