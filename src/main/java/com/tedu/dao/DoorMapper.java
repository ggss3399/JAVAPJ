package com.tedu.dao;

import java.util.List;

import com.tedu.pojo.Door;

public interface DoorMapper {

	public List<Door> findAll();

	public void deleteById(Integer id);

	public Door findById(Integer id);

	public void doorUpdate(Door door);

	public void doorAdd(Door door);

}
