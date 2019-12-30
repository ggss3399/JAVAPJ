package com.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.dao.DoorMapper;
import com.tedu.pojo.Door;

@Controller
public class DoorController {
	@Autowired
	DoorMapper dao;
	@RequestMapping("/{page}")
	public String  toPage(@PathVariable String page) {
		return page;
	}
	@RequestMapping("/doorList")
	public String doorList(Model model) {
		List<Door> list = dao.findAll();
		model.addAttribute("dlist", list);
		return "door_list";
	}

	@RequestMapping("doorDelete")
	public String doorDelete(Integer id) {
		dao.deleteById(id);
		return "forward:/doorList";
	}
	@RequestMapping("doorInfo")
	public String doorInfo(Integer id,Model model) {
		Door door = dao.findById(id);
		model.addAttribute("door", door);
		return "forward:door_update";
	}
	@RequestMapping("/doorUpdate")
	public String doorUpdate(Door door ) {
		dao.doorUpdate(door);
		return "forward:/doorList";
	}
	@RequestMapping("/doorAdd")
	public String doorAdd(Door door) {
		dao.doorAdd(door);
		return "forward:/doorList";
	}
	
}
