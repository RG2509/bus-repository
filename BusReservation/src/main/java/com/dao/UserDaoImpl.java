package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.model.Bus;
import com.model.Users;


@Repository("userdao")
public class UserDaoImpl implements UserDaoIntf {
	
	@PersistenceContext
	EntityManager em;
	
	// user

		/*
		 * public List<Bus> getBuses(){ EntityManagerFactory emf =
		 * Persistence.createEntityManagerFactory("pu"); EntityManager em =
		 * emf.createEntityManager();
		 * 
		 * @SuppressWarnings("unchecked") List<Bus> buses =
		 * em.createQuery("SELECT b FROM  Bus b  ").getResultList(); em.close(); return
		 * buses; }
		 */

	
	/*
	 * public boolean addBus(Bus bus) { boolean flag = false; try {
	 * System.out.println(bus); em.persist(bus);
	 * 
	 * // em.close(); System.out.println("end"); flag = true; } catch (Exception e)
	 * { System.out.println("Error:" + e); } return flag;
	 * 
	 * }
	 */
		
		public boolean registerPassenger(Users user) {

			boolean flag = false;
			try {
				 System.out.println(user);
				 em.persist(user);
				
				 System.out.println("end");
				 flag = true; 
			} catch (Exception e) {
				System.out.println("Error:" + e);
			
			}

			return flag;
		}

		public Users validateUser(Users user) {
			Users f = null;
			try {
				f = (Users) em.createQuery("SELECT f FROM Users f WHERE f.Email=:email and f.Password=:pwd")
						.setParameter("email", user.getEmail()).setParameter("pwd", user.getPassword()).getSingleResult();
			} catch (Exception e) {
				System.out.println(e);
			}
			
			System.out.println(f);
			return f;
		}

		
		public List<Bus> getBus() {
			@SuppressWarnings("unchecked")
			List<Bus> buslist = em.createQuery("SELECT u FROM  Bus u").getResultList();

			return buslist;
		}
}
