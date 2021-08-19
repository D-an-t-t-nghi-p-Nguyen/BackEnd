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

import com.example.demo.dao.NewsDao;
import com.example.demo.entity.NewsEntity;
import com.example.demo.entity.NewsRequest;
import com.example.demo.exception.UserServiceException;
import com.example.demo.service.NewsService;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("http://localhost:4200")
public class NewsController {
	
	@Autowired
	private NewsDao newsDao;
	
	@Autowired
	private NewsService newsService;
	
	private static String upload ="D:\\Project\\doan\\admin-panel\\src\\assets\\images\\";
	
	@GetMapping("news")
	public ResponseEntity<?> GetNews(){
		return new ResponseEntity<>(newsService.GetNews(),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("news")
	public ResponseEntity<?> AddMotel(@RequestBody NewsRequest blogRequest){
		return new ResponseEntity<>(newsService.AddNews(blogRequest),HttpStatus.CREATED);
	}
	
	@GetMapping("news/{id}")
	public ResponseEntity<?> GetMotelById( @PathVariable Integer id){
		NewsEntity entity = newsDao.findById(id).orElseThrow();
		return ResponseEntity.ok(entity);
	}
	@PutMapping("news/{id}")
	public ResponseEntity<?> UpdateMotel(@RequestBody NewsRequest blogRequest, @PathVariable Integer id){
		return new ResponseEntity<>(newsService.UpdateNews(blogRequest, id),HttpStatus.ACCEPTED);
	}
	@DeleteMapping("news/{id}")
	public Boolean DeleteMotel(@PathVariable Integer id) {
		newsService.DeleteNews(id);
		return true;
	}
	
	@PostMapping("news/upload/{id}")
    public ResponseEntity<?>UplaodFile(@RequestParam MultipartFile file,@PathVariable Integer id){
		NewsEntity entity = newsDao.findById(id).get();
        String FileName= UserServiceException.UploadOneFile(file,upload);
        entity.setImage(FileName);
        newsDao.save(entity);
        return new ResponseEntity<>(entity,HttpStatus.ACCEPTED);
    }
	
//	@GetMapping("news-ByUser")
//	public ResponseEntity<?> GetAllMotelByUser(@RequestParam String email){
//		return new ResponseEntity<>(blogService.GetAllBlogByUser(email),HttpStatus.ACCEPTED);
//	}

}
