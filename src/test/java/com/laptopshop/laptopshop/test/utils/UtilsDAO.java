package com.laptopshop.laptopshop.test.utils;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class UtilsDAO {

	@PersistenceContext
	private EntityManager em;

	private String makeTable = "INSERT into Laptop VALUES "
			+ "(1, 'Macbook Air', 'Apple', '11.6-inch', '1.6GHz dual-core Intel Core i5', '4GB', '256GB flash storage', 'Intel HD Graphics 6000', 2, 1279.00), "
			+ "(2, 'Macbook Air', 'Apple', '13.3-inch', '1.6GHz dual-core Intel Core i5', '8GB', '512GB flash storage', 'Intel HD Graphics 6000', 2, 1379.00  ), "
			+ "(3, 'Macbook', 'Apple', '12-inch', '1.1GHz dual-core Intel Core m3', '8GB', '512GB flash storage', 'Intel HD Graphics 515', 1, 1650.00), "
			+ "(4, 'Macbook Pro', 'Apple', '13.3-inch', '2.7GHz dual-core Intel Core i5', '8GB', '256GB flash storage', 'Intel Iris Graphics 6100', 2, 1699.00), "
			+ "(5, 'Macbook Pro', 'Apple', '15.4-inch', '2.5GHz quad-core Intel Core i7', '16GB', '512GB flash storage', 'AMD Radeon R9 M370X with 2GB of GDDR5', 3, 2849.00), "
			+ "(6, 'XPS', 'Dell', '13.3 inch', '6th Generation Intel Core i7-6560U ', '16GB', '512GB flash storage', 'Intel® Iris Graphics', 2, 1849.00), "
			+ "(7, 'XPS', 'Dell', '15.4 inch', '6th Generation Intel Core™ i7-6700HQ', '32GB', '1TB flash storage', 'NVIDIA® GeForce® GTX 960M with 2GB GDDR5', 3, 2449.00), "
			+ "(8, 'Alienware', 'Dell', '13.3-inch', 'Intel® Core™ i7-6500U Dual-Core', '8GB', '256GB flash storage', 'NVIDIA® GeForce® GTX 960M with 4GB GDDR5', 3, 1349.48), "
			+ "(9, 'Alienware', 'Dell', '15.4-inch', 'Intel® Core™ i7-6500U Dual-Core', '8GB', '1TB 7.2k SATA 6Gb/s', 'NVIDIA® GeForce® GTX 980M with 8GB GDDR5', 3, 1899.49), "
			+ "(10, 'Alienware', 'Dell', '17.3-inch', 'Intel® Core™ i7-6820HK Quad-Core', '8GB', '0.5TB flash + 1TB HDD', 'NVIDIA® GeForce® GTX 980M with 8GB GDDR5', 4, 2699.49), "
			+ "(11, 'Yoga 900', 'Lenovo ', '13.3-inch', '2.5GHz dual-core Intel Core i7', '8GB', '256GB flash storage', 'Intel HD Graphics', 2, 1099.99), "
			+ "(12, 'Y70', 'Lenovo ', '17.3-inch', 'Intel 4th Generation Core i7', '8GB', '1TB HDD', 'NVIDIA® GeForce® GTX 960M with 4GB', 2, 1299.99), "
			+ "(13, 'Y700', 'Lenovo ', '15.6-inch', '2.6GHz dual-core Intel Core i7', '8GB', '1TB HDD', 'NVIDIA® GeForce® GTX 960M with 4GB', 2, 1499.99), "
			+ "(14, 'Y900', 'Lenovo ', '13.3-inch', '2.5GHz dual-core Intel Core i7', '8GB', '512GB flash storage', 'Intel HD Graphics', 2, 1415.99), "
			+ "(15, 'ROG', 'Asus', '17.3-inch', '2.7GHz quad-core Intel Core i7', '64GB', '0.5TB flash + 1TB HDD', 'NVIDIA® GeForce® GTX 960M with 4GB GDDR5', 4, 3249.49), "
			+ "(16, 'Zenbook Pro', 'Asus', '15.6-inch', '2.6GHz Intel 6th Generation Core i7', '16GB', '512GB flash storage', 'NVIDIA® GeForce® GTX 960M with 2GB GDDR5', 3, 1699.00), "
			+ "(17, 'Zenbook Pro', 'Asus', '13.3-inch', '2.4GHz Intel 6th Generation Core i7', '12GB', '512GB flash storage', 'NVIDIA® GeForce® GTX 940M with 2GB GDDR5', 2, 1299.00), "
			+ "(18, 'Predator', 'Acer', '17.3-inch', '2.6GHz quad-core Intel Core i7', '32GB', '0.5TB flash + 1TB HDD', 'NVIDIA® GeForce® GTX 960M with 4GB GDDR5', 4, 2599.99), "
			+ "(19, 'Predator', 'Acer', '15.6-inch', '2.6GHz quad-core Intel Core i7', '16GB', '0.25TB flash + 1TB HDD', 'NVIDIA® GeForce® GTX 960M with 4GB GDDR5', 3, 1999.99), "
			+ "(20, 'Aspire V Nitro', 'Acer', '15.6-inch', '2.6GHz dual-core Intel Core i7', '8GB', '1TB HDD', 'NVIDIA® GeForce® GTX 960M with 2GB GDDR5', 2,  	999.99), "
			+ "(21, 'Omen', 'HP', '15.6-inch', '2.5GHz quad-core Intel Core i7', '16GB', '256GB flash storage', 'NVIDIA® GeForce® GTX 860M with 2GB GDDR5', 3, 1999.99), "
			+ "(22, 'Envy', 'HP', '15.6-inch', '2.3GHz dual-core Intel Core i5', '12GB', '2TB HDD', 'NVIDIA® GeForce® GTX 940M with 2GB GDDR5', 2, 1199.99), "
			+ "(23, 'Envy', 'HP', '13.3-inch', '2.3GHz dual-core Intel Core i5', '8GB', '256GB flash storage', 'Intel HD Graphics', 2, 929.99), "
			+ "(24, 'Satellite', 'Toshiba', '15.6-inch', '3.0GHz dual-core Intel Core i7', '16GB', '512GB flash storage', 'Intel HD 520 Graphics', 2, 1449.49), "
			+ "(25, 'Satellite', 'Toshiba', '12-inch', '2.5GHz dual-core Intel Core i7', '8GB', '512GB flash storage', 'Intel HD 520 Graphics', 2, 1449.49);";

	public void deleteTable() {
		em.createQuery("DELETE FROM Laptop").executeUpdate();
	}

	public void reBuildTable() {
		em.createQuery(makeTable).executeUpdate();
	}

}
