package com.springMongo.rafael.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springMongo.rafael.domain.User;
import com.springMongo.rafael.dto.UserDTO;
import com.springMongo.rafael.service.UserServices;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	public UserServices services;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {

		List<User> list = services.findAll();
		List<UserDTO> listDTO = list.stream().map(obj -> new UserDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<User> finById(@PathVariable String id) {
		
		User obj = services.findId(id);
		return ResponseEntity.ok().body(obj);
	
	}

}
