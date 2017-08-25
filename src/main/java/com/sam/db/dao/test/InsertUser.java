package com.sam.db.dao.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.sam.db.models.User;

public class InsertUser {

	public static void main(String[] args) {
		// 1 : Ouverture unité de travail JPA
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentLink");
				EntityManager em = emf.createEntityManager();

				// 2 : Ouverture transaction
				EntityTransaction tx = em.getTransaction();
				tx.begin();

				// 3 : Instanciation Objet métier
				User user = new User();
				user.setEmail("sam@gmail.com");
				user.setFirstName("Samuel");
				user.setLastName("Besnier");
				user.setPassword("1234");
				user.setUsername("sam");

				// 4 : Persistance Objet/Relationnel : création d'un enregistrement en
				// base
				em.persist(user);

				// 5 : Fermeture transaction
				tx.commit();

				// 6 : Fermeture unité de travail JPA
				em.close();
				emf.close();
	}

}
