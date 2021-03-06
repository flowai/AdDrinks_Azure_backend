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
import de.addrinks.backend.model.Abonnement;
import de.addrinks.backend.model.Bestellung;
import de.addrinks.backend.model.Kategorie;
import de.addrinks.backend.model.Kunde;
import de.addrinks.backend.model.Produkt;
import de.addrinks.backend.model.PunkteProView;
import de.addrinks.backend.model.User;
import de.addrinks.backend.service.AbonnementServiceImpl;
import de.addrinks.backend.service.BestellungService;
import de.addrinks.backend.service.BestellungServiceImpl;
import de.addrinks.backend.service.KategorieServiceImpl;
import de.addrinks.backend.service.KundeServiceImpl;
import de.addrinks.backend.service.ProductServiceImpl;
import de.addrinks.backend.service.PunkteProViewServiceImpl;
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
	
	@Autowired
	ProductServiceImpl produktService;
	
	@Autowired
	KategorieServiceImpl kategorieService;
	
	@Autowired
	BestellungServiceImpl bestellungService;
	
	@Autowired
	AbonnementServiceImpl abonnementService;
	
	@Autowired
	KundeServiceImpl kundeService;
	
	@Autowired
	PunkteProViewServiceImpl ppvService;
	
    //----------- createAbonnement -------
	/*
	 * {
	 *	"nutzerId": "12543-2245-211",
	 *	"produktId": "123-321-2334",
	 *	"menge": "11",
	 *	"status": "OFFEN"
	 *}
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/abonnement", method = RequestMethod.POST)
	public ResponseEntity<?> createAbonnement(@RequestBody Abonnement abonnement, UriComponentsBuilder uriCB) throws Exception{
        logger.info("Creating Abonnement : {}", abonnement);
        
        //TODO Id is never the same - therefore use another combination
        if (abonnementService.abonnementExists(abonnement.getId())) {
            logger.error("Unable to create. An Abonnement with ID {} already exist", abonnement.getId());
            return new ResponseEntity(new HTTPError("Unable to create. An Abonnement with name " + 
            abonnement.getId() + " already exist."),HttpStatus.CONFLICT);
        }
        abonnementService.saveAbonnement(abonnement);
 
        HttpHeaders headers = new HttpHeaders();
        
        headers.setLocation(uriCB.path("/abonnement/{id}").buildAndExpand(abonnement.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	//----------- createBestellung -------
	/*
	 * {
	 *	"nutzerId": "12543-2245-211",
	 *	"produktId": "123-321-2334",
	 *	"menge": "11",
	 *	"status": "OFFEN"
	 *}
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/bestellung", method = RequestMethod.POST)
	public ResponseEntity<?> createBestellung(@RequestBody Bestellung bestellung, UriComponentsBuilder uriCB) throws Exception{
        logger.info("Creating Bestellung : {}", bestellung);
        
        //TODO Id is never the same - therefore use another combination
        if (bestellungService.bestellungExists(bestellung.getId())) {
            logger.error("Unable to create. A Bestellung with ID {} already exist", bestellung.getId());
            return new ResponseEntity(new HTTPError("Unable to create. A Bestellung with name " + 
            bestellung.getId() + " already exist."),HttpStatus.CONFLICT);
        }
        bestellungService.saveBestellung(bestellung);
 
        HttpHeaders headers = new HttpHeaders();
        
        headers.setLocation(uriCB.path("/bestellung/{id}").buildAndExpand(bestellung.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	//----------- createKategorie --------
	/*
	 * {
	 *	"name": "Tabs",
	 *	"beschreibung": "Tabs sind mit Filterpapier umschlossene Kaffeemengen für eine oder zwei Tassen."
	 *}
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/kategorie", method = RequestMethod.POST)
	public ResponseEntity<?> createKategorie(@RequestBody Kategorie kategorie, UriComponentsBuilder uriCB) throws Exception{
        logger.info("Creating Kategorie : {}", kategorie);
        
        //TODO Id is never the same - therefore use another combination
        if (kategorieService.kategorieExists(kategorie.getId())) {
            logger.error("Unable to create. A Kategorie with name {} already exist", kategorie.getKategoriename());
            return new ResponseEntity(new HTTPError("Unable to create. A Produkt with name " + 
            kategorie.getKategoriename() + " already exist."),HttpStatus.CONFLICT);
        }
        kategorieService.saveKategorie(kategorie);
 
        HttpHeaders headers = new HttpHeaders();
        
        headers.setLocation(uriCB.path("/kategorie/{id}").buildAndExpand(kategorie.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	//----------- createKunde --------
	/*
	 * {
	 *	"nutzer": "12332-123-532-12",
	 *	"abo": "123123-43241-1233-4314",
	 *	"bezahlung": "bezahlung - platzhalter"
	 *}
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/kunde", method = RequestMethod.POST)
	public ResponseEntity<?> createKunde(@RequestBody Kunde kunde, UriComponentsBuilder uriCB) throws Exception{
        logger.info("Creating Kunde : {}", kunde);
        
        //TODO Id is never the same - therefore use another combination
        if (kundeService.kundeExists(kunde.getId())) {
            logger.error("Unable to create. A Kunde with name {} already exist", kunde.getId());
            return new ResponseEntity(new HTTPError("Unable to create. A Kunde with name " + 
            kunde.getId() + " already exist."),HttpStatus.CONFLICT);
        }
        kundeService.saveKunde(kunde);
 
        HttpHeaders headers = new HttpHeaders();
        
        headers.setLocation(uriCB.path("/kunde/{id}").buildAndExpand(kunde.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	//-------- create Produkt ------------
	/*
	 * {
	 *	"name": "Senseo",
	 *	"kategorie": "7f6a34cc-ba70-45df-9d20-0e873cfeba6e",
	 *	"bestand": "150",
	 *	"beschreibung": "Senseo Tabs. Die Senseotabs haben ein besonderes Geschmacksaroma.",
	 *	"punkte": "4",
	 *	"uri": "https://www.senseo.de/siteassets/kaffee/klassiker/nmsenseo_classic_left_relaunch_ge_cw23_2015.png?preset=blendpage-page-image",
	 *	"hausnummer": "40",
	 *	"einkaufspreis": "2.49",
	 *	"waehrung": "EUR"
	 *}
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/produkt", method = RequestMethod.POST)
	public ResponseEntity<?> createProdukt(@RequestBody Produkt produkt, UriComponentsBuilder uriCB) throws Exception{
        logger.info("Creating Produkt : {}", produkt);
        
        //TODO Id is never the same - therefore use another combination
        if (produktService.produktExist(produkt.getId())) {
            logger.error("Unable to create. A Produkt with name {} already exist", produkt.getName());
            return new ResponseEntity(new HTTPError("Unable to create. A Produkt with name " + 
            produkt.getName() + " already exist."),HttpStatus.CONFLICT);
        }
        produktService.saveProdukt(produkt);
 
        HttpHeaders headers = new HttpHeaders();
        
        headers.setLocation(uriCB.path("/produkt/{id}").buildAndExpand(produkt.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	//----------- createProduktsBulk ---------
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/produktsBulk/", method = RequestMethod.POST)
	public ResponseEntity<?> createProduktsBulk(@RequestBody List<Produkt> produkts){
        logger.info("Creating Produkts bulk");
        
        long[] ids = produktService.produktBulkExist(produkts);
        if (ids.length > 0) {
            logger.error("Unable to create. Produkts with ids {} already exist", ids.toString());
            return new ResponseEntity(new HTTPError("Unable to create. Produkts with ids " + 
            ids.toString() + " already exist."),HttpStatus.CONFLICT);
        }
        produktService.saveProduktBulk(produkts);
 
        //TODO httpheaders is missing
        return new ResponseEntity(HttpStatus.CREATED);
	}
	
	//--------- Create PunkteProView ---------
	/*
	 * {
	 * 	"": "",
	 *  "": "",
	 *  "": ""
	 * }
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/punkteproview", method = RequestMethod.POST)
	public ResponseEntity<?> createPunkteProView(@RequestBody PunkteProView ppv, UriComponentsBuilder uriCB) throws Exception{
        logger.info("Creating Punkte pro View : {}", ppv);
        
        //TODO Id is never the same - therefore use another combination
        if (ppvService.ppvExist(ppv.getId())) {
            logger.error("Unable to create. Punkte pro View with id {} already exist", ppv.getId());
            return new ResponseEntity(new HTTPError("Unable to create. Punkte pro View " + 
            ppv.getId() + " already exist."),HttpStatus.CONFLICT);
        }
        ppvService.savePPV(ppv);
 
        HttpHeaders headers = new HttpHeaders();
        
        headers.setLocation(uriCB.path("/punkteproview/{id}").buildAndExpand(ppv.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
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
	
	//----------- deleteAllProdukts ----------
    @RequestMapping(value = "/produkts", method = RequestMethod.DELETE)
    public ResponseEntity<Produkt> deleteAllProdukts() {
        logger.info("Deleting All Users");
 
        produktService.deleteAllProdukts();
        return new ResponseEntity<Produkt>(HttpStatus.NO_CONTENT);
    }
	
	// -------- Delete All Users ------
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteAllUsers() {
        logger.info("Deleting All Users");
 
        userService.deleteAllUsers();
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
    
    //----------- deleteProdukt --------------
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/produkt/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteProdukt(@PathVariable UUID id){
		logger.info("Deleting produkt with id {}", id);
		
		if(!(produktService.produktExist(id))){
			logger.error("Unable to delete. A produkt with id {} does not exist", id);
			return new ResponseEntity(new HTTPError("Unable to delete. A produkt with id "+id+" does not exist."), HttpStatus.NOT_FOUND);
		}
		
		produktService.deleteProduktById(id);
		return new ResponseEntity<Produkt>(HttpStatus.NO_CONTENT);
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
	
	//----------- getAbonnements ---------
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/abonnements", method = RequestMethod.GET)
	public ResponseEntity<List<Abonnement>> getAbonnements(){
		logger.info("Fetching all Bestellungen");
		
		List<Abonnement> abonnements = abonnementService.getAbonnements();
		if(abonnements.isEmpty()) {
			logger.info("No abonnements in database");
			return new ResponseEntity(new HTTPError("No abonnements in database"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Abonnement>>(abonnements, HttpStatus.OK);
	}
	
	//----------- getBestellung ----------
	//----------- getBestellungen --------
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/bestellung", method = RequestMethod.GET)
	public ResponseEntity<List<Bestellung>> getBestellungen(){
		logger.info("Fetching all Bestellungen");
		
		List<Bestellung> bestellungen = bestellungService.getBestellungen();
		if(bestellungen.isEmpty()) {
			logger.info("No bestellungen in database");
			return new ResponseEntity(new HTTPError("No bestellungen in database"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Bestellung>>(bestellungen, HttpStatus.OK);
	}
	
	//----------- getKategorie -----------
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/kategorie/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getKategorie(@PathVariable("id") UUID id) {
		logger.info("Fetching Kategorie with id {}", id);
		
		Kategorie kategorie = kategorieService.getKategorie(id);
		if(kategorie == null){
			logger.error("Kategorie with id {} not found", id);
			return new ResponseEntity(new HTTPError("Kategorie with id "+id+" not found"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Kategorie>(kategorie, HttpStatus.OK);
	}
	
	//----------- updateProduktsBulk ---------
	//TODO
	
	//----------- getKategorien ----------
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/kategorien", method = RequestMethod.GET)
	public ResponseEntity<List<Kategorie>> getKategorien(){
		logger.info("Fetching all Kategories");
		
		List<Kategorie> kategorien = kategorieService.getKategorien();
		if(kategorien.isEmpty()) {
			logger.info("No produkts in database");
			return new ResponseEntity(new HTTPError("No produkts in database"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Kategorie>>(kategorien, HttpStatus.OK);
	}
	
	//---------- GetProdukt -----------
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/produkt/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getProdukt(@PathVariable("id") UUID id) {
		logger.info("Fetching Produkt with id {}", id);
		
		Produkt produkt = produktService.getProdukt(id);
		if(produkt == null){
			logger.error("Produkt with id {} not found", id);
			return new ResponseEntity(new HTTPError("Produkt with id "+id+" not found"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Produkt>(produkt, HttpStatus.OK);
	}
	
	//--------- GetProdukts -----------
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/produkts", method = RequestMethod.GET)
	public ResponseEntity<List<Produkt>> getProdukts(){
		logger.info("Fetching all Produkts");
		
		List<Produkt> produkts = produktService.getProdukts();
		if(produkts.isEmpty()) {
			logger.info("No produkts in database");
			return new ResponseEntity(new HTTPError("No produkts in database"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Produkt>>(produkts, HttpStatus.OK);
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
	
    //----------- updateKategorie --------
	//TODO
	
	
	@RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello AdDrinks!";
    }
	
	//----------- updateProdukt --------------
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/produkt/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateProdukt(@PathVariable UUID id, @RequestBody Produkt produkt) throws Exception{
		logger.info("Updating Produkt with id {}", id);
		
		if(!(produktService.produktExist(produkt.getId()))){
			logger.error("Unable to update. A produkt with name {} does not exist", produkt.getName());
			return new ResponseEntity(new HTTPError("Unable to update. Produkt does not exist."), HttpStatus.NOT_FOUND);
		}
		
		produktService.updateProdukt(id, produkt);
		
		return new ResponseEntity<Produkt>(produkt, HttpStatus.OK);
	}
	
	//----------- updateBestellung -------
	//----------- updateBestellungen -----
	//----------- createBestellungen -----
	//----------- deleteBestellung -------
	//----------- deleteAllBestellungen --
	
	
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
	
}
