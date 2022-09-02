package com.springboot.springmvc.controller.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springmvc.dao.EmployeeDAO;
import com.springboot.springmvc.entity.Room;

//@Controller
@RestController // by default it is understood that response body has to be sent and not the name of a view.
public class RoomControllerWS {

	public RoomControllerWS() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	EmployeeDAO dao;
	/*
	@GetMapping("/rooms")
	@ResponseBody
	public String getAllRooms() {
		 return dao.findAll().toString();
	}
	
	@GetMapping("/rooms/{roomNumber}")
	@ResponseBody
	public String getRoom(@PathVariable int roomNumber) {
		return dao.findById(roomNumber).toString();
	}*/
	
	@GetMapping(path ="/rooms",produces={"application/json"})
	//@ResponseBody
	public List<Room> getAllRooms() {
		 return dao.findAll();
	}
	
	@GetMapping("/rooms/{roomNumber}")
	//@ResponseBody
	public Room getRoom(@PathVariable int roomNumber) {
		return dao.findById(roomNumber).orElse(new Room());
	}
	
	@PostMapping("/rooms")// this method is for form data
	public void addRoom(Room room) {
		dao.save(room);
	}
	
	//@PostMapping(path="/roooms", consumes= {"application/json"}) // this method is for json data as we have given the RequestBOdy annotation.
	@PostMapping("/roooms")
	public void adddRoom(@RequestBody Room room) {
		dao.save(room);
	}
	
	@DeleteMapping("/rooms/{roomNumber}") // we are sending this as path variable.
	public void deleteRoom(@PathVariable int roomNumber) {
		dao.deleteById(roomNumber);
	}
    
	@PutMapping("/rooms")
	public void updateRoom(@RequestBody Room room) { // we have to use request body annotation when 
		// we are receiveing json or xml from the client side.
		dao.save(room);
	}
	
	// when it is a rest controller then we do not have to give response body annotation.
	// for REST services we dont need to write a controller.
}
