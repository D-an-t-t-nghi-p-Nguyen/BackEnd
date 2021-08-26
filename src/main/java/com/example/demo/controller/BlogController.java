package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.BlogDao;
import com.example.demo.entity.BlogEntity;
import com.example.demo.entity.BlogRequest;
import com.example.demo.exception.UserServiceException;
import com.example.demo.service.BlogService;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("http://localhost:4200")
public class BlogController {

	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private BlogService blogService;
	
	private static String upload ="D:\\Project\\doan\\admin-panel\\src\\assets\\images\\";
	
	@GetMapping("blog")
	public ResponseEntity<?> GetMotel(){
		return new ResponseEntity<>(blogService.GetBlog(),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("blog")
	public ResponseEntity<?> AddMotel(@RequestBody BlogRequest blogRequest){
		return new ResponseEntity<>(blogService.AddBlog(blogRequest),HttpStatus.CREATED);
	}
	
	@GetMapping("blog/{id}")
	public ResponseEntity<?> GetMotelById( @PathVariable Integer id){
		BlogEntity entity = blogDao.findById(id).orElseThrow();
		return ResponseEntity.ok(entity);
	}
	@PutMapping("blog/{id}")
	public ResponseEntity<?> UpdateMotel(@RequestBody BlogRequest blogRequest, @PathVariable Integer id){
		return new ResponseEntity<>(blogService.UpdateBlog(blogRequest, id),HttpStatus.ACCEPTED);
	}
	@DeleteMapping("blog/{id}")
	public Boolean DeleteMotel(@PathVariable Integer id) {
		blogService.DeleteBlog(id);
		return true;
	}
	
	@PostMapping("blog/upload/{id}")
    public ResponseEntity<?>UplaodFile(@RequestParam MultipartFile file, @RequestParam MultipartFile file1, @RequestParam MultipartFile file2,@PathVariable Integer id){
        BlogEntity entity = blogDao.findById(id).get();
        String FileName= UserServiceException.UploadOneFile(file,upload);
        String FileName1= UserServiceException.UploadOneFile(file1,upload);
        String FileName2= UserServiceException.UploadOneFile(file2,upload);
        entity.setImage(FileName);
        entity.setImage1(FileName1);
        entity.setImage2(FileName2);
        blogDao.save(entity);
        return new ResponseEntity<>(entity,HttpStatus.ACCEPTED);
    }
	
	@GetMapping("blog-ByUser")
	public ResponseEntity<?> GetAllMotelByUser(@RequestParam String email){
		return new ResponseEntity<>(blogService.GetAllBlogByUser(email),HttpStatus.ACCEPTED);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
