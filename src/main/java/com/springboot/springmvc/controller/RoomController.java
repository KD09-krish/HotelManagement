package com.springboot.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.springmvc.dao.EmployeeDAO;
import com.springboot.springmvc.entity.Room;


@Controller
@RequestMapping("/")
public class RoomController {

	@Autowired
	EmployeeDAO dao;
	
	public RoomController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("general/getAvailableRooms")
	public ModelAndView checkRoomAvailability()
	{
	   ModelAndView mv = new ModelAndView("roomList");
	   List<Room> rooms = dao.findByRoomStatus("A");
	   mv.addObject("rooms",rooms);
	   mv.addObject("status","A");
	   return mv;
	}
	
	@GetMapping("secure/getAvailableRooms")
	public ModelAndView getAvailableRooms()
	{
	   ModelAndView mv  = new ModelAndView("roomList");
	   List<Room> rooms = dao.findByRoomStatus("A");
	   mv.addObject("rooms",rooms);
	   mv.addObject("status","A");
	   return mv;
	}
	
	@GetMapping("secure/getOccupiedRooms")
	public ModelAndView getOccupiedRooms()
	{

		   ModelAndView mv = new ModelAndView("roomList");
		   List<Room> rooms = dao.findByRoomStatus("O");
		   mv.addObject("rooms",rooms);
		   mv.addObject("status","O");
		   return mv;
	}
	
	@GetMapping("secure/allocateRoom")
	public String allocateRoom(Room room)
	{
		Room actualRoom = dao.findById(room.getRoomNumber()).orElse(new Room());
		actualRoom.setRoomStatus("O");
		dao.save(actualRoom);
		return "roomAllocated";
	}
	
	/*@GetMapping("secure/deallocateRoom")
	public String deallocateRoom(Room room )
	{
		Room actualRoom = dao.findById(room.getRoomNumber()).orElse(new Room());
		actualRoom.setRoomStatus("A");
		dao.save(actualRoom);
		return "roomDeallocated";
	}*/
	
	/*@GetMapping("secure/deallocateRoom")
	public String deallocateRoom(@RequestParam int roomNumber ) // request parameter by the name roomNumber
	{
		Room actualRoom = dao.findById(roomNumber).orElse(new Room());
		actualRoom.setRoomStatus("A");
		dao.save(actualRoom);
		return "roomDeallocated";
	}*/
	
	@GetMapping("secure/deallocateRoom")
	public String deallocateRoom(@RequestParam("roomNumber") int roomNo ) // request parameter by the name roomNumber
	{
		Room actualRoom = dao.findById(roomNo).orElse(new Room());
		actualRoom.setRoomStatus("A");
		dao.save(actualRoom);
		return "roomDeallocated";
	}
	

}
