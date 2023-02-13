package com.laptopshop.laptopshop.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.laptopshop.laptopshop.data.LaptopDAO;
import com.laptopshop.laptopshop.model.Laptop;

@Path("/inventory")
@Stateless
@LocalBean
public class LaptopWS {

	@EJB
	private LaptopDAO laptopDAO;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllLaptops() {
		System.out.println("Get all Laptops");
		List<Laptop> laptops = laptopDAO.findAllLaptops();
		System.out.println("...got laptops...");
		System.out.println(laptops.size());
		return Response.status(200).entity(laptops).build();
	}

	@GET
	@Path("/name/{query}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getByName(@PathParam("query") String query) {
		System.out.println("findByName: " + query);
		List<Laptop> laptops = laptopDAO.findLaptopsByName(query);
		if (laptops.size() != 0) {
			return Response.status(200).entity(laptops).build();
		} else {
			return Response.status(416).entity(laptops).build();
		}
	}

	@GET
	@Path("/brand/{query2}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getLaptopsByBrand(@PathParam("query2") String query) {
		System.out.println("findLaptopsByBrand: " + query);
		List<Laptop> laptops = laptopDAO.findLaptopsByBrand(query);
		if (laptops.size() != 0) {
			return Response.status(200).entity(laptops).build();
		} else {
			return Response.status(416).entity(laptops).build();
		}
	}

	@GET
	@Path("/memory/{query3}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getLaptopsByMemory(@PathParam("query3") String query) {
		System.out.println("findLaptopsByMemory: " + query);
		List<Laptop> laptops = laptopDAO.findLaptopsByMemory(query);
		if (laptops.size() != 0) {
			return Response.status(200).entity(laptops).build();
		} else {
			return Response.status(416).entity(laptops).build();
		}
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/{id}")
	public Response getLaptopById(@PathParam("id") int id) {
		Laptop laptop = laptopDAO.findLaptopById(id);
		if (laptop != null) {
			return Response.status(200).entity(laptop).build();
		} else {
			return Response.status(416).entity(laptop).build();
		}
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public Response saveLaptop(Laptop laptop) {
		laptopDAO.save(laptop);
		return Response.status(200).entity(laptop).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updateLaptop(Laptop laptop) {
		laptopDAO.update(laptop);
		return Response.status(200).entity(laptop).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteLaptop(@PathParam("id") int id) {
		laptopDAO.delete(id);
		return Response.status(204).build();
	}

	// @GET
	// @Path("/search/{query4}")
	// @Produces({ MediaType.APPLICATION_JSON })
	// public Response getAnyLaptops(@PathParam("query4") String query) {
	// System.out.println("getAnyLaptops: " + query);
	// List<Laptop> laptops = laptopDAO.findAnyLaptops(query);
	// if (laptops.size() != 0) {
	// return Response.status(200).entity(laptops).build();
	// } else {
	// return Response.status(416).entity(laptops).build();
	// }
	// }

}
