package de.addrinks.backend.apprepo;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import de.addrinks.backend.error.HTTPError;
import de.addrinks.backend.model.User;
import de.addrinks.backend.service.UserServiceImpl;

/*
 * Controller that is responsible for the endpoints
 */

@RestController
@RequestMapping("/")
public class RESTController{
	
	public static final Logger logger = LoggerFactory.getLogger(RESTController.class);
	
	@Autowired
	UserServiceImpl userService;
	
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
	
	// ------  Get User by ID  -------
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("id") UUID id) {
		logger.info("Fetching User with id {}", id);
		
		User user = userService.getUser(id);
		if(user == null){
			logger.error("User with id {} not found", id);
			return new ResponseEntity(new HTTPError("User with id "+id+" not found"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	// ------- Get all Users -------
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers(){
		logger.info("Fetching all Users");
		
		List<User> users = userService.getUsers();
		if(users.isEmpty()) {
			logger.info("No users in database");
			return new ResponseEntity(new HTTPError("No users in database"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	// -------- Create User -------
	/*
	 * {
	 *	"vorname": "Florian",
	 *	"nachname": "Waidner",
	 *	"geburtsjahr": "1986",
	 *	"geburtsmonat": "6",
	 *	"geburtstag": "17",
	 *	"straße": "Burgstr.",
	 *	"hausnummer": "40",
	 *	"ort": "Kirkel",
	 *	"plz": "66459"
	 *}
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder uriCB) throws Exception{
        logger.info("Creating User : {}", user);
        
        //TODO Id is never the same - therefore use another combination
        if (userService.userExist(user.getId())) {
            logger.error("Unable to create. A User with name {} already exist", user.getNachname());
            return new ResponseEntity(new HTTPError("Unable to create. A User with name " + 
            user.getNachname() + " already exist."),HttpStatus.CONFLICT);
        }
        userService.saveUser(user);
 
        HttpHeaders headers = new HttpHeaders();
        
        headers.setLocation(uriCB.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	// -------- Update User -------
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable UUID id, @RequestBody User user) throws Exception{
		logger.info("Updating User with id {}", id);
		
		if(!(userService.userExist(user.getId()))){
			logger.error("Unable to update. A user with name {} does not exist", user.getNachname());
			return new ResponseEntity(new HTTPError("Unable to update. User does not exist."), HttpStatus.NOT_FOUND);
		}
		
		userService.updateUser(id, user);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	// -------- Create Users -------
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/usersBulk/", method = RequestMethod.POST)
	public ResponseEntity<?> createUsersBulk(@RequestBody List<User> users){
        logger.info("Creating Users bulk");
        
        long[] ids = userService.userBulkExist(users);
        if (ids.length > 0) {
            logger.error("Unable to create. Users with ids {} already exist", ids.toString());
            return new ResponseEntity(new HTTPError("Unable to create. Users with ids " + 
            ids.toString() + " already exist."),HttpStatus.CONFLICT);
        }
        userService.saveUsersBulk(users);
 
        //TODO httpheaders is missing
        return new ResponseEntity(HttpStatus.CREATED);
	}
	
	// -------- Update Users -------
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/usersBulk/", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUsersBulk(@RequestBody List<User> users){
		logger.info("Updating Users Bulk");
		
		long[] ids = userService.userBulkExist(users);
		
		if(ids.length != users.size()){
			logger.error("Unable to update. Users already exist");
			return new ResponseEntity(new HTTPError("Unable to update. Users already exist."), HttpStatus.CONFLICT);
		}
		
		userService.updateUsersBulk(users);
		
		return new ResponseEntity(HttpStatus.OK);
	}
	
	// -------- Delete User ------
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable UUID id){
		logger.info("Deleting user with id {}", id);
		
		if(!(userService.userExist(id))){
			logger.error("Unable to delete. A user with id {} does not exist", id);
			return new ResponseEntity(new HTTPError("Unable to delete. A user with id "+id+" does not exist."), HttpStatus.NOT_FOUND);
		}
		
		userService.deleteUserById(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	
	// -------- Delete All Users ------
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteAllUsers() {
        logger.info("Deleting All Users");
 
        userService.deleteAllUsers();
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
}
