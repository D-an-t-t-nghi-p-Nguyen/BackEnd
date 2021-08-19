package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.OderRequest;
import com.example.demo.service.OderService;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("http://localhost:4200")
public class OderController {
	
	@Autowired
	private OderService oderService;
	
	@GetMapping("oder")
	public ResponseEntity<?> GetOder(){
		return new ResponseEntity<>(oderService.GetOder(),HttpStatus.ACCEPTED);
	}
	@GetMapping("oderdelete")
	public ResponseEntity<?> GetOderDelete(){
		return new ResponseEntity<>(oderService.GetOderDelete(),HttpStatus.ACCEPTED);
	}
	@GetMapping("oder-bymotel")
	public ResponseEntity<?> GetOderByMotel( @RequestParam Integer motel_id){
		return new ResponseEntity<>(oderService.GetOderByBlog(motel_id),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("oder")
	public ResponseEntity<?> CreateOder(@RequestBody OderRequest oderRequest ){
		return new ResponseEntity<>(oderService.CreateOder(oderRequest),HttpStatus.CREATED);
	}
	
    @DeleteMapping("oder/{id}")
    public Boolean DeleteOder(@PathVariable Integer id){
    	oderService.DeleteOder(id);       
       return true;
    }

}
