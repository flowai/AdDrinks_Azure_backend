package de.addrinks.backend.service;

import java.util.List;
import java.util.UUID;

import org.bson.Document;

import de.addrinks.backend.model.User;

public interface UserService {

	User getUser(UUID id);

	List<User> getUsers();

	boolean userExist(UUID id);

	void saveUser(User user) throws Exception;

	void updateUser(UUID id, User user) throws Exception;

	long[] userBulkExist(List<User> users);

	void saveUsersBulk(List<User> users);

	void updateUsersBulk(List<User> users);

	void deleteUserById(UUID id);

	void deleteAllUsers();

}
