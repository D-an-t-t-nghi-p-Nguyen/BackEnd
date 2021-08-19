package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.TalkDao;
import com.example.demo.entity.Talk;
import com.example.demo.exception.ResourceNotFoundException;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/")
public class TalkController {

	@Autowired
	private TalkDao talkDao;
	
	@GetMapping("/talk")
	public List<Talk> getAllOder(){
		return talkDao.findAll();
	}
	
	@PostMapping("/talk")
	public Talk createOder(@RequestBody Talk talk) {
		return talkDao.save(talk);
	}
	
	@DeleteMapping("/talk/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteOder(@PathVariable Integer id){
		Talk talk = talkDao.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		talkDao.delete(talk);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
		
	}
}