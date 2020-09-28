package com.capg.otms.ms.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.capg.otms.ms.exception.MovieException;
import com.capg.otms.ms.model.Login;
import com.capg.otms.ms.model.Screen;
import com.capg.otms.ms.service.ScreenServiceImpl;

@RestController
@CrossOrigin("*")  // it will allow resource sharing between different origins
@RequestMapping("/screen")
public class ScreenController {

	@Autowired // service object will be injected into controller while creating controller in
	// WebApplicationContext
	
	ScreenServiceImpl screenService; // we cannot create object to an interface but we can have a reference

	@GetMapping("admin/login/{user}/{pass}")
	public ResponseEntity<Login>  findUserLogin(@PathVariable("user") String username, @PathVariable("pass") String password) 
	{
	  
		 Login log = screenService.findUser(username,password);
		 if(log==null) {
			 throw new MovieException("Login not successfull");
		 }
		 return new ResponseEntity<>(log,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/all")  // This is request mapping with get method
	public List<Screen> findAllScreens() {

		return screenService.findAllScreens();

	}

	@GetMapping("/{id}")
	// inorder to map a parameter from uri to method parameters we use @pathvariable
	public ResponseEntity<Screen> findScreenById(@PathVariable("id") int screenId) throws MovieException {

		return new ResponseEntity<>(screenService.getScreenById(screenId), HttpStatus.OK);
	}
	@PostMapping("/add")

	// requestbody maps httprequest json format data from the client to the local
	// object screen
	public ResponseEntity<Screen> createScreen(@RequestBody Screen screen) {
		return new ResponseEntity<>(screenService.addScreen(screen), HttpStatus.OK);
	}

		

	@PutMapping("/update")
	public Screen updateTheScreenById(@RequestBody Screen screen) {

		return screenService.updateScreenById(screen);

	}

	@DeleteMapping("/delete/id/{id}")
	public void deleteScreenById(@PathVariable("id") int screenId) { 	// inorder to map a parameter from model to method parameters we use @pathvariable


		screenService.deleteScreenById(screenId);

	}
}
