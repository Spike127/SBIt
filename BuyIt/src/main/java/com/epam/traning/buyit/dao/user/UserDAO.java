package com.epam.traning.buyit.dao.user;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epam.traning.buyit.model.User;

@Repository("userDAO")
public class UserDAO implements UserDAOInterface {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createElement(User elem) {
//		sessionFactory.getCurrentSession().save(elem);
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.save(elem);
		} catch (Exception e) {
			System.out.println("I/O Exeption");
			System.err.println(e.getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public User getElementById(int id) {
		Session session = null;
		User user = null;
		try {
			session = sessionFactory.openSession();
			user = (User) session.get(User.class, id);
		} catch (Exception e) {
			System.out.println("I/O Exeption");
			System.err.println(e.getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return user;
	}

	@Override
	public void updateElement(User elem) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.update(elem);
		} catch (Exception e) {
			System.out.println("I/O Exeption");
			System.err.println(e.getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

	}

	@Override
	public void deleteElement(User elem) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.delete(elem);
		} catch (Exception e) {
			System.out.println("I/O Exeption");
			System.err.println(e.getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		Session session = null;
		List<User> users = new ArrayList<User>();
		try {
			session = sessionFactory.openSession();
			users = session.createCriteria(User.class).list();
		} catch (Exception e) {
			System.out.println("I/O Exeption");
			System.err.println(e.getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return users;
	}

	@Override
	public boolean checkLogin(String login) {
		throw new UnsupportedOperationException();
	}

	@Override
	public User getUser(String login, String password) {
		throw new UnsupportedOperationException();
	}

	@Override
	public User getUserByLogin(String login) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean changePasswordByUserId(int id, String newPassword) {
		throw new UnsupportedOperationException();
	}

}
