package com.springboot.springmvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.springmvc.entity.Room;

public interface EmployeeDAO extends JpaRepository<Room,Integer>{

	public List<Room> findByRoomStatus(String roomStatus);
}
