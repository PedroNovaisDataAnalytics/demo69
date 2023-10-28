package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
    UserRepository repository;

    public List<User> findAllUsers() {
    	return repository.findAll();
    }
    
    public User findById(Long id) throws ResourceNotFoundException {
        try {
            return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found"));
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("User with id " + id + " not found");
        }
    }
    
    public Optional<User> findByEmail(String email) {
    	return repository.findUserByEmail(email);
    }

    public String insert(User user) {
//    	Optional<User> userToBeAdded = repository.findById(user.getId());
//    	
//    	if (!userToBeAdded.isPresent()) {
//    		throw new NoSuchElementException("User already registered");
//    	}
    	
    	repository.save(user);
		return "User added succesfully";
    }
    
    public String delete(String email) throws ResourceNotFoundException {
        try {
            Optional<User> userToBeDeleted = repository.findUserByEmail(email);
            
            if (!userToBeDeleted.isPresent()) {
                throw new NoSuchElementException("User not found");
            }
            
            repository.deleteById(userToBeDeleted.get().getId());
            return email;
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("User with email " + email + " not found");
        }
    }
    
    public String update(String email, User user) throws ResourceNotFoundException {
        try {
            Optional<User> userToBeUpdated = repository.findUserByEmail(email);
            
            if (!userToBeUpdated.isPresent()) {
                throw new NoSuchElementException("User not found");
            }
            
            User updatedUser = userToBeUpdated.get();
            updatedUser.setNome(user.getNome());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setTelefone(user.getTelefone());
            updatedUser.setPassword(user.getPassword());
            repository.save(updatedUser);
            
            return "User has been updated successfully";
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("User with email " + email + " not found");
        }
    }
}
