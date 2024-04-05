package com.techymeet.SpringbootRepositorycurd.Controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.techymeet.SpringbootRepositorycurd.Bo.UserBo;
import com.techymeet.SpringbootRepositorycurd.Entity.UserVo;
import com.techymeet.SpringbootRepositorycurd.Service.UserService;
@RestController
public class UserController {
	@Autowired
	private UserService userService;
		@PostMapping("/createuser")
	public ResponseEntity<UserBo> adduser(@RequestBody UserBo userbo){
		
		try {
			userbo=userService.createuser(userbo);
			
		}catch(Exception e) {
			 e.printStackTrace();
			
		}
		if(null==userbo) {
			   return new ResponseEntity<UserBo>(userbo,HttpStatus.NOT_FOUND);
		   }
		 return new ResponseEntity<UserBo>(userbo,HttpStatus.OK);
		
	}
	
	@GetMapping(path="/list")
	public ResponseEntity<List<UserVo>> getuser(){
		
			List<UserVo> list=new ArrayList<>();
			list=userService.getuser();
			return ResponseEntity.ok(list);
		
	}
	 @PutMapping(path="/update")
	 public ResponseEntity<UserBo> updateuser(@RequestBody UserBo userBo){
		 userBo=userService.updateuser(userBo);
		return ResponseEntity.ok(userBo);
	 }
		@DeleteMapping("/delete/{id}")	
		 public ResponseEntity<UserBo> deleteuser(@PathVariable("id") int id){
			
			int userId=0;
			userId=userService.deleteuser(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	 @PostMapping(path="/search/{name}")
		public ResponseEntity<List<UserBo>> searchByName(@PathVariable String name){
		 List<UserBo> list=new ArrayList<>();
		 try {
			 list=userService.searchByUserName(name);
			 if(null==list) {
				 return new ResponseEntity<List<UserBo>>(list,HttpStatus.NOT_FOUND);
				 }
		 }catch (Exception e) {
			// TODO: handle exception
		}
		 return new ResponseEntity<List<UserBo>>(list,HttpStatus.OK);
		 
	 }
	 
	 @PostMapping(path="/findByName/{name}")
		public ResponseEntity<List<UserBo>> findByName(@PathVariable String name){
		 List<UserBo> list=new ArrayList<>();
		 try {
			 list=userService.findByName(name);
			 if(null==list) {
				 return new ResponseEntity<List<UserBo>>(list,HttpStatus.NOT_FOUND);
				 }
		 }catch (Exception e) {
			// TODO: handle exception
		}
		 return new ResponseEntity<List<UserBo>>(list,HttpStatus.OK);
		 
	 }
	 @GetMapping(path="/{id}")
		public ResponseEntity<UserBo> getUser(@PathVariable int id){
		 UserBo userBo=null;
		 try {
			 userBo=userService.getUserById(id);
			  }catch (Exception e) {
				  e.printStackTrace();
		}
		 if(null==userBo) {
			   return new ResponseEntity<UserBo>(userBo,HttpStatus.NOT_FOUND);
		   }
		 return new ResponseEntity<UserBo>(userBo,HttpStatus.OK);
				 
	 }




	
}
