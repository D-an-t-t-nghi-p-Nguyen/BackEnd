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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.UserEntity;
import com.example.demo.entity.UserRequest;
import com.example.demo.exception.UserServiceException;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("http://localhost:4200")
public class UserController {
@Autowired
private UserService userService;
@Autowired
private  UserDao userDao;
private static String upload ="D:\\Project\\doan\\admin-panel\\src\\assets\\images\\";

    @GetMapping("user")
    public ResponseEntity<?> getAllUser(){
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.ACCEPTED);
    }

    @GetMapping( "roles")
    public ResponseEntity<?> getallRoles(){
        return new ResponseEntity<>(userService.getallRoles(), HttpStatus.ACCEPTED);
    }
    @PostMapping("user")
    public ResponseEntity<?> AddUser(@RequestBody UserRequest userRequest) throws Exception{
        String temp_email = userRequest.getEmailId();
        if(temp_email != null && !"".equals(temp_email)){
            UserEntity userEntityObj = userService.fetchUserEntityByEmailId(temp_email);
            if (userEntityObj !=null){
                throw new Exception("user with "   + temp_email + "is already exit");
            }
        }
        return new ResponseEntity<>(this.userService.AddUser(userRequest),HttpStatus.CREATED);

    }
    
    @PostMapping("user/upload/{id}")
    public ResponseEntity<?>UplaodFile(@RequestParam MultipartFile file,@PathVariable Integer id){
        UserEntity entity = userDao.findById(id).get();
        String FileName= UserServiceException.UploadOneFile(file,upload);
        entity.setAvatar(FileName);
        userDao.save(entity);
        return new ResponseEntity<>(entity,HttpStatus.ACCEPTED);
    }
    
    @GetMapping("user/{id}")
    public ResponseEntity<?>GetUserById(@PathVariable Integer id){
        UserEntity entity= userDao.findById(id).orElseThrow();
        return  ResponseEntity.ok(entity);
    }
    
    @PutMapping("user/{id}")
    public ResponseEntity<?>UpdateUser(@PathVariable Integer id, @RequestBody UserRequest userRequest){
        return new ResponseEntity<>(this.userService.UpdateUser(userRequest,id),HttpStatus.ACCEPTED);
    }
    
    @DeleteMapping("user/{id}")
    public Boolean DeleteUser(@PathVariable Integer id){
        userService.DeleteUser(id);       
       return true;
    }
    @GetMapping("user-findByEmail/{email_id}")
    public ResponseEntity<?> fetchUserEntityByEmailId(@PathVariable String email_id){
 	   return new ResponseEntity<>(userService.fetchUserEntityByEmailId(email_id), HttpStatus.ACCEPTED);
    }

    @PostMapping("login")
    @ResponseBody
    public UserEntity LoginUserentity(@RequestBody UserEntity userEntity) throws Exception{
          String temp_email= userEntity.getEmailId();
          String temp_password=userEntity.getPassword();
          UserEntity userEntityObj = null;
          if(temp_email != null && temp_password != null){
              userEntityObj = userService.fetchUserEntityByEmailIdAndPassword(temp_email,temp_password);
          }
          if(userEntityObj == null){
              throw new Exception("Bad credentials");
          }
          return userEntityObj;
    }

}
