package com.example.demo.resource;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import com.example.demo.services.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

    @Autowired
    UserService service;
    
    @GetMapping("/getUserByid/{id}")
    public User getUser(@PathVariable(value="id") Long id) throws ResourceNotFoundException {
    	return service.findById(id);
    }
    
    @GetMapping("/getAllUsers")
    public List<User> getAllusers() {
		return service.findAllUsers();
    }
       
    @PostMapping("/insert")
    public String insertUser(@RequestBody User user) {
		return service.insert(user);
    }
    
    @DeleteMapping("/delete/{email}")
    public String deleteUser(@PathVariable(value="email") String email) {
        try {
            return service.delete(email);
        } catch(NoSuchElementException e) {
            return "User not found";
        } catch(ResourceNotFoundException e) {
            return "User not found";
        } catch(Exception e) {
            return "An error occurred " + e;
        }
    }
    
    @PutMapping("/update/{email}")
    public String updateUser(@PathVariable(value="email") String email, @RequestBody User user) {
    	try {
	    	return service.update(email, user);
		} catch(NoSuchElementException e) {
			return "User not found";
		} catch(Exception e) {
			return "An error ocurred " + e;
		}	
    }
    
    
}
