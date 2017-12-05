package de.addrinks.backend.azure;

import java.util.List;
import java.util.UUID;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import de.addrinks.backend.model.User;

@Service
public class MongoDBController<E> {
	public static final Logger logger = LoggerFactory.getLogger(MongoDBController.class);
	
	MongoClientURI uri = new MongoClientURI("mongodb://addrinksmongo:XI20eP2tKXRfz3HHNLoYq8QiEE4V8OTwa6tP61Daz5ZnmMf1CEjpRp16Qv6DfBofiagj2p1QzMjErRzoAiKWXQ==@addrinksmongo.documents.azure.com:10255/?ssl=true&replicaSet=globaldb");
	
    private static final String DBNAME = "addrinks";
    private static final String MODEL = "de.addrinks.engine.model";
    
    Morphia morphia = new Morphia();
    
    MongoClient mongo = new MongoClient(uri);    
    Datastore datastore = morphia.createDatastore(mongo, DBNAME);

    
	public MongoDBController(){
		morphia.mapPackage(MODEL);

	}

	public void insertDocument(E entity) throws Exception {
		logger.info("Save document to database");
		
		try{
			Key<E> key = datastore.save(entity);			
		}catch(Exception e){
			logger.error("Document was not saved to Database.");
			throw new Exception("Document was not saved to Database", e);
		}
	}


	public void updateDocument(UUID id, E entity) throws Exception {
		logger.info("Update document with id {}", id);
		
		try{
			//TODO Key<E> key = datastore.createUpdateOperations(User.class).			
		}catch(Exception e){
			logger.error("Entity was not saved to Database.");
			throw new Exception("Entity was not saved to Database", e);
		}
	}

	public User getUser(UUID id) {
		logger.info("Get User with id {}", id);
		
		User obj = datastore.get(User.class, id);
		//TODO transfer object
		return obj;
		
	}

	public List<User> getUsers() {
		logger.info("Get all Users");
		
		List<User> users = datastore.createQuery(User.class).asList();
		return users;
	}

	public boolean existUser(UUID id) {
		if(this.getUser(id) != null){
			return true;
		}else{
			return false;
		}
	}

	public void deleteUserById(UUID id) {
		final Query<User> query = datastore.createQuery(User.class)
                .filter("id $eq", id);
		datastore.findAndDelete(query);
		
	}

	public void deleteAllUsers() {
		//TODO Check if legit
		final Query<User> query = datastore.createQuery(User.class);
		datastore.delete(query);
		
	}
	


}
