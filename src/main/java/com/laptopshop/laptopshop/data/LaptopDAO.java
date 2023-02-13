package com.laptopshop.laptopshop.data;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.laptopshop.laptopshop.model.Laptop;

@Stateless
@LocalBean
public class LaptopDAO {

	@PersistenceContext
	private EntityManager em;

	public List<Laptop> findAllLaptops() {
		Query query = em.createQuery("Select l from Laptop l");
		return query.getResultList();
	}

	public List<Laptop> findLaptopsByName(String lapName) {
		Query query = em.createQuery("SELECT n FROM Laptop AS n " + "WHERE n.lapName LIKE ?1");
		query.setParameter(1, "%" + lapName.toUpperCase() + "%");
		return query.getResultList();
	}

	public List<Laptop> findLaptopsByBrand(String brand) {
		Query query = em.createQuery("SELECT n FROM Laptop AS n " + "WHERE n.brand LIKE ?1");
		query.setParameter(1, "%" + brand.toUpperCase() + "%");
		return query.getResultList();
	}

	public List<Laptop> findLaptopsByMemory(String memory) {
		Query query = em.createQuery("SELECT n FROM Laptop AS n " + "WHERE n.lapMem LIKE ?1");
		query.setParameter(1, "%" + memory.toUpperCase() + "%");
		return query.getResultList();
	}

	public Laptop findLaptopById(int id) {
		return em.find(Laptop.class, id);
	}

	public void save(Laptop laptop) {
		em.persist(laptop);
	}

	public void update(Laptop laptop) {
		System.out.println("Laptop with id: " + laptop.getId() + " was updated");
		em.merge(laptop);
	}

	public void delete(int id) {
		System.out.println("Laptop with id: " + id + " was deleted.");
		em.remove(findLaptopById(id));
	}

	// public List<Laptop> findAnyLaptops(String searchTerm) {
	// String queries = "SELECT l FROM Laptop l";
	// if (!searchTerm.equals("")) {
	// String search = " WHERE (l.id LIKE '" + searchTerm + "'" + " OR l.lapName
	// LIKE '" + searchTerm + "'"
	// + " OR l.brand LIKE '" + searchTerm + ")'";
	// // + " OR l.display LIKE '" + searchTerm + "'"
	// // + " OR l.processor LIKE '" + searchTerm + "'" + " OR l.lapMem
	// // LIKE '" + searchTerm + "'"
	// // + " OR l.hardDrive LIKE '" + searchTerm + "'" + " OR l.graphics
	// // LIKE '" + searchTerm + "'"
	// // + " OR l.numUsb LIKE '" + searchTerm + "'" + " OR l.price LIKE '"
	// // + searchTerm + ")'";
	// queries = "SELECT l FROM Laptop as l " + search;
	// }
	//
	// System.out.println(queries);
	//
	// Query query = em.createQuery(queries);
	// return query.getResultList();
	// }

}
