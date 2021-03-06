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

import de.addrinks.backend.model.Abonnement;
import de.addrinks.backend.model.Bestellung;
import de.addrinks.backend.model.Kategorie;
import de.addrinks.backend.model.Kunde;
import de.addrinks.backend.model.Produkt;
import de.addrinks.backend.model.PunkteProView;
import de.addrinks.backend.model.User;

@Service
public class MongoDBController {
	public static final Logger logger = LoggerFactory.getLogger(MongoDBController.class);
	
	private static final String DBNAME = "addrinks";
	
    private static final String MODEL = "de.addrinks.engine.model";
    MongoClientURI uri = new MongoClientURI("mongodb://addrinksmongo:XI20eP2tKXRfz3HHNLoYq8QiEE4V8OTwa6tP61Daz5ZnmMf1CEjpRp16Qv6DfBofiagj2p1QzMjErRzoAiKWXQ==@addrinksmongo.documents.azure.com:10255/?ssl=true&replicaSet=globaldb");
    
    Morphia morphia = new Morphia();
    
    MongoClient mongo = new MongoClient(uri);    
    Datastore datastore = morphia.createDatastore(mongo, DBNAME);

    
	public MongoDBController(){
		morphia.mapPackage(MODEL);

	}

	public void deleteAllKategories() {
		//TODO Check if legit
		final Query<Kategorie> query = datastore.createQuery(Kategorie.class);
		datastore.delete(query);
	}


	public void deleteAllProdukts() {
		//TODO Check if legit
		final Query<Produkt> query = datastore.createQuery(Produkt.class);
		datastore.delete(query);
	}

	public void deleteAllUsers() {
		//TODO Check if legit
		final Query<User> query = datastore.createQuery(User.class);
		datastore.delete(query);
	}

	public void deleteKategorieById(UUID id) {
		final Query<Kategorie> query = datastore.createQuery(Kategorie.class)
                .filter("id $eq", id);
		datastore.findAndDelete(query);
	}

	public void deleteProduktById(UUID id) {
		final Query<Produkt> query = datastore.createQuery(Produkt.class)
                .filter("id $eq", id);
		datastore.findAndDelete(query);
	}

	public void deleteUserById(UUID id) {
		final Query<User> query = datastore.createQuery(User.class)
                .filter("id $eq", id);
		datastore.findAndDelete(query);
	}

	public boolean existAbonnement(UUID id) {
		if(this.getAbonnement(id) != null){
			return true;
		}else{
			return false;
		}
	}

	public boolean existBestellung(UUID id) {
		if(this.getBestellung(id) != null){
			return true;
		}else{
			return false;
		}
	}

	public boolean existKategorie(UUID id) {
		if(this.getKategorie(id) != null){
			return true;
		}else{
			return false;
		}
	}

	public boolean existKunde(UUID id) {
		if(this.getKunde(id) != null){
			return true;
		}else{
			return false;
		}
	}

	public boolean existPPV(UUID id) {
		if(this.getPPV(id) != null){
			return true;
		}else{
			return false;
		}
	}

	public boolean existProdukt(UUID id) {
		if(this.getProdukt(id) != null){
			return true;
		}else{
			return false;
		}
	}

	public boolean existUser(UUID id) {
		if(this.getUser(id) != null){
			return true;
		}else{
			return false;
		}
	}

	private Object getAbonnement(UUID id) {
		logger.info("Get Abonnement with id {}", id);
		
		Abonnement obj = datastore.get(Abonnement.class, id);
		//TODO transfer object
		return obj;	
	}

	public List<Abonnement> getAbonnements() {
		logger.info("Get all Abonnements");
		
		List<Abonnement> abonnements = datastore.createQuery(Abonnement.class).asList();
		return abonnements;
	}

	private Object getBestellung(UUID id) {
		logger.info("Get Bestellung with id {}", id);
		
		Bestellung obj = datastore.get(Bestellung.class, id);
		//TODO transfer object
		return obj;	
	}

	public List<Bestellung> getBestellungen() {
		logger.info("Get all Bestellungen");
		
		List<Bestellung> bestellungen = datastore.createQuery(Bestellung.class).asList();
		return bestellungen;
	}

	public Kategorie getKategorie(UUID id) {
		logger.info("Get Kategorie with id {}", id);
		
		Kategorie obj = datastore.get(Kategorie.class, id);
		//TODO transfer object
		return obj;
	}

	public List<Kategorie> getKategories() {
		logger.info("Get all Kategories");
		
		List<Kategorie> kategories = datastore.createQuery(Kategorie.class).asList();
		return kategories;
	}

	private Object getKunde(UUID id) {
		logger.info("Get Kunde with id {}", id);
		
		Kunde obj = datastore.get(Kunde.class, id);
		//TODO transfer object
		return obj;	
	}

	private Object getPPV(UUID id) {
		logger.info("Get PPV with id {}", id);
		
		PunkteProView obj = datastore.get(PunkteProView.class, id);
		//TODO transfer object
		return obj;	
	}

	public Produkt getProdukt(UUID id) {
		logger.info("Get Produkt with id {}", id);
		
		Produkt obj = datastore.get(Produkt.class, id);
		//TODO transfer object
		return obj;
	}

	public List<Produkt> getProdukts() {
		logger.info("Get all Produkts");
		
		List<Produkt> products = datastore.createQuery(Produkt.class).asList();
		return products;
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

	public void insertAbonnement(Abonnement abo) throws Exception {
		logger.info("Save document to database");
		
		try{
			Key<Abonnement> key = datastore.save(abo);			
		}catch(Exception e){
			logger.error("Document was not saved to Database.");
			throw new Exception("Document was not saved to Database", e);
		}	
	}

	public void insertBestellung(Bestellung bestellung) throws Exception {
		logger.info("Save document to database");
		
		try{
			Key<Bestellung> key = datastore.save(bestellung);			
		}catch(Exception e){
			logger.error("Document was not saved to Database.");
			throw new Exception("Document was not saved to Database", e);
		}
	}

	public void insertKategorie(Kategorie kategorie) throws Exception {
		logger.info("Save document to database");
		
		try{
			Key<Kategorie> key = datastore.save(kategorie);			
		}catch(Exception e){
			logger.error("Document was not saved to Database.");
			throw new Exception("Document was not saved to Database", e);
		}
	}

	public void insertKunde(Kunde kunde) throws Exception {
		logger.info("Save document to database");
		
		try{
			Key<Kunde> key = datastore.save(kunde);			
		}catch(Exception e){
			logger.error("Document was not saved to Database.");
			throw new Exception("Document was not saved to Database", e);
		}
	}

	public void insertPPV(PunkteProView ppv) throws Exception {
		logger.info("Save document to database");
		
		try{
			Key<PunkteProView> key = datastore.save(ppv);			
		}catch(Exception e){
			logger.error("Document was not saved to Database.");
			throw new Exception("Document was not saved to Database", e);
		}
	}

	public void insertProdukt(Produkt produkt) throws Exception {
		logger.info("Save document to database");
		
		try{
			Key<Produkt> key = datastore.save(produkt);			
		}catch(Exception e){
			logger.error("Document was not saved to Database.");
			throw new Exception("Document was not saved to Database", e);
		}
	}

	public void insertUser(User user) throws Exception {
		logger.info("Save document to database");
		
		try{
			Key<User> key = datastore.save(user);			
		}catch(Exception e){
			logger.error("Document was not saved to Database.");
			throw new Exception("Document was not saved to Database", e);
		}
	}

	public void updateKategorie(UUID id, Kategorie kategorie) throws Exception {
		logger.info("Update document with id {}", id);
		
		try{
			//TODO Key<E> key = datastore.createUpdateOperations(User.class).			
		}catch(Exception e){
			logger.error("Entity was not saved to Database.");
			throw new Exception("Entity was not saved to Database", e);
		}
	}

	public void updateProdukt(UUID id, Produkt produkt) throws Exception {
		logger.info("Update document with id {}", id);
		
		try{
			//TODO Key<E> key = datastore.createUpdateOperations(User.class).			
		}catch(Exception e){
			logger.error("Entity was not saved to Database.");
			throw new Exception("Entity was not saved to Database", e);
		}
	}

	public void updateUser(UUID id, User user) throws Exception {
		logger.info("Update document with id {}", id);
		
		try{
			//TODO Key<E> key = datastore.createUpdateOperations(User.class).			
		}catch(Exception e){
			logger.error("Entity was not saved to Database.");
			throw new Exception("Entity was not saved to Database", e);
		}
	}
	


}
