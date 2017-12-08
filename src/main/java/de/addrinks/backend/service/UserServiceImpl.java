package de.addrinks.backend.service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.addrinks.backend.azure.MongoDBController;
import de.addrinks.backend.model.User;
import de.addrinks.backend.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	private static final String COLLECTIONNAME = "user";
	
	@Autowired
	MongoDBController mongoDBController;

	@Override
	public User getUser(UUID id) {
		logger.info("Get a specific User with id {}",id);
		User user = mongoDBController.getUser(id);
		
		return user;
	}

	@Override
	public List<User> getUsers() {
		logger.info("Get all Users");
		List<User> users = mongoDBController.getUsers();
		return users;
	}

	@Override
	public boolean userExist(UUID id) {
		logger.info("Check if Document is existing");
		return mongoDBController.existUser(id);
	}

	@Override
	public void saveUser(User user) throws Exception {
		logger.info("Save User of Entity");
		mongoDBController.insertUser(user);
	}

	@Override
	public void updateUser(UUID id, User user) throws Exception {
		logger.info("Update User of Entity");
		mongoDBController.updateUser(id, user);
	}

	@Override
	public long[] userBulkExist(List<User> users) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUsersBulk(List<User> users) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUsersBulk(List<User> users) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserById(UUID id) {
		logger.info("Delete user by id");
		mongoDBController.deleteUserById(id);
	}

	@Override
	public void deleteAllUsers() {
		logger.info("Delete all Users");
		mongoDBController.deleteAllUsers();
	}

}
