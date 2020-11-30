package fr.isika.cdi6.starevent.web.managedbeans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.UploadedFile;

import fr.isika.cdi6.starevent.dao.repositories.UtilisateurRepository;
import fr.isika.cdi6.starevent.data.model.admin.Admin;
import fr.isika.cdi6.starevent.data.model.enums.Statut;
import fr.isika.cdi6.starevent.data.model.enums.Type;
import fr.isika.cdi6.starevent.data.model.gestion.Partenaire;
import fr.isika.cdi6.starevent.data.model.offres.Offre;
import fr.isika.cdi6.starevent.data.model.taches.Tache;
import fr.isika.cdi6.starevent.data.model.taches.ToDo;
import fr.isika.cdi6.starevent.services.AdminService;
import fr.isika.cdi6.starevent.services.OffreService;
import fr.isika.cdi6.starevent.services.PartenaireService;
import fr.isika.cdi6.starevent.services.TacheService;
import fr.isika.cdi6.starevent.services.ToDoService;

@Named("profilAdminMb")
@SessionScoped
public class ProfilAdminManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private LoginManagedBean loginMb;
	
	@Inject
	private OffreManagedBean offreMb;

	@Inject
	private TacheService tacheService;

	@Inject
	private ToDoService toDoService;

	@Inject
	private OffreService offreService;
	@Inject
	private	UtilisateurRepository ur;
	@Inject
	private AdminService adminService;

	@Inject
	private PartenaireService partenaireService;
	
	private UploadedFile file;
	
	private List<ToDo> toDoList;

	private Admin adminConnecte;

	private String todoPriority;

	private String statutSelect;

	private String newStatut;

	private Tache tacheCree;

	private Integer idPartenaireSelectionne;

	private Offre offreCree;

	private List<Tache> listeTaches = new ArrayList<>();
	private List<Partenaire> listPartners = new ArrayList<>();
	private List<Integer> listUtils = new ArrayList<>();

	private List<Statut> listStatus = new ArrayList<Statut>();
	private List<Type> listPriority = new ArrayList<>();

	private Date dateSelect;

	@PostConstruct
	public void init() {
		adminConnecte = (Admin) adminService.findById(loginMb.getId());
		listPartners = partenaireService.findAll();
		listUtils = ur.findAll().stream().filter(u->u.getIdUtilisateur()>0).map(u->u.getIdUtilisateur()).collect(Collectors.toList());
		tacheCree = new Tache();
		offreCree=new Offre();
		listeTaches = tacheService.findAll().stream().filter(t -> !t.getStatutTache().equals(Statut.ANNULE))
				.collect(Collectors.toList());
		toDoList = toDoService.findAll();

		listStatus.add(Statut.EN_COURS);
		listStatus.add(Statut.ANNULE);
		listStatus.add(Statut.TERMINE);

		listPriority.add(Type.URGENT);
		listPriority.add(Type.NORMAL);
		listPriority.add(Type.RELANCE);

	}

	// -------------------UTILS----------------
	private LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	private LocalDate getDateSelect(SelectEvent e) {

		if ((e.getObject() != null) && (e.getObject() != "")) {

			dateSelect = (Date) e.getObject();
		}
		return convertToLocalDateViaInstant(dateSelect);
	}

//--------------------OPERATION SUR TACHE----------------------------
	public void selectDateDebutTache(SelectEvent e) {
		tacheCree.setDate_debut(this.getDateSelect(e));
	}

	public void selectDateFinTache(SelectEvent e) {
		tacheCree.setDate_fin(this.getDateSelect(e));
	}

	public void affecterDescriptionTache(ValueChangeEvent e) {
		String description = e.getNewValue().toString();
		tacheCree.setDescription(description);

	}

	public void affecterStatut() {

		switch (statutSelect) {
		case "EN_COURS":
			tacheCree.setStatutTache(Statut.EN_COURS);
			break;
		case "ANNULE":
			tacheCree.setStatutTache(Statut.ANNULE);
			break;
		case "TERMINE":
			tacheCree.setStatutTache(Statut.TERMINE);
			break;
		default:
			tacheCree.setStatutTache(Statut.EN_COURS);
			break;
		}
	}

	public void modifierStatut(Tache tache) {

		switch (newStatut) {

		case "EN_COURS":
			tache.setStatutTache(Statut.EN_COURS);
			tacheService.update(tache);
			break;
		case "ANNULE":
			tache.setStatutTache(Statut.ANNULE);
			tacheService.update(tache);
			break;
		case "TERMINE":
			tache.setStatutTache(Statut.TERMINE);
			tacheService.update(tache);
			break;
		default:
			tache.setStatutTache(Statut.EN_COURS);
			tacheService.update(tache);
		}
	}
//--------------CREATION TACHE ---------------------------------

	public void creerTache(Tache tache) {
		this.affecterStatut();

		Optional<ToDo> todoUrgent;
		ToDo todo = new ToDo();

		switch (todoPriority) {
		case "URGENT":
			todoUrgent = toDoList.stream().filter(t -> t.getTypeToDo().equals(Type.URGENT)).findFirst();
			todo = todoUrgent.get();
			tacheService.ajouter(tache, todo.getIdToDo());
			toDoService.update(todo);
			break;

		case "RELANCE":
			todoUrgent = toDoList.stream().filter(t -> t.getTypeToDo().equals(Type.RELANCE)).findFirst();
			todo = todoUrgent.get();
			tacheService.ajouter(tache, todo.getIdToDo());
			toDoService.update(todo);
			break;

		case "NORMAL":
			todoUrgent = toDoList.stream().filter(t -> t.getTypeToDo().equals(Type.URGENT)).findFirst();
			todo = todoUrgent.get();
			tacheService.ajouter(tache, todo.getIdToDo());
			toDoService.update(todo);
			break;
		}

		this.listeTaches = tacheService.findAll().stream().filter(t -> !t.getStatutTache().equals(Statut.ANNULE))
				.collect(Collectors.toList());

	}

//---------------MINI CRUD--------------------

	public void deleteTask(Tache tache) {
		// On conserve la reservation en base de données avec un statut ANNULE
		tache.setStatutTache(Statut.ANNULE);
		tacheService.update(tache);
		this.listeTaches = tacheService.findAll().stream().filter(t -> !t.getStatutTache().equals(Statut.ANNULE))
				.collect(Collectors.toList());
	}

	public void update() {
		tacheService.update(tacheCree);
		this.listeTaches = tacheService.findAll().stream().filter(t -> !t.getStatutTache().equals(Statut.ANNULE))
				.collect(Collectors.toList());

	}
//-------------OPERATION OFFRE-------------------------

	
	 public void upload() {
	        if (file != null) {
	            FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
	            FacesContext.getCurrentInstance().addMessage(null, message);
	        }
	    }
	 
	

	public void selectImage(ValueChangeEvent e) {
		
		String imageOffre = e.getNewValue().toString();
		offreCree.setImageOffre(imageOffre);

	}

//----------------CREATION OFFRE------------------------------------

	public void creerOffre() {

		Partenaire partenaireSelectionne = partenaireService.findById(idPartenaireSelectionne);
		offreCree.setPartenaire(partenaireSelectionne);
		offreCree.setInfoComplementaire("Information complementaire");
		
		offreCree.setImageOffre("resources/images/Capture.PNG");
		//https://img.freepik.com/vecteurs-libre/fond-technologie-hud-abstraite_23-2148250643.jpg?size=626&ext=jpg&ga=GA1.2.1158341606.1602679821
		offreService.ajouter(offreCree, idPartenaireSelectionne);

		//partenaireSelectionne.getCataloguePartenaires().ajouter(offreCree);
		partenaireService.update(partenaireSelectionne);
		offreMb.getOffres().add(offreCree);
		offreService.update(offreCree);
		offreCree=new Offre();
	}

// -------------------getter/setter----------------

	public TacheService getTacheService() {
		return tacheService;
	}

	public void setTacheService(TacheService tacheService) {
		this.tacheService = tacheService;
	}

	public ToDoService getToDoService() {
		return toDoService;
	}

	public void setToDoService(ToDoService toDoService) {
		this.toDoService = toDoService;
	}

	public Tache getTacheCree() {
		return tacheCree;
	}

	public void setTacheCree(Tache tacheCree) {
		this.tacheCree = tacheCree;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getDateSelect() {
		return dateSelect;
	}

	public void setDateSelect(Date dateSelect) {
		this.dateSelect = dateSelect;
	}

	public List<Statut> getListStatus() {
		return listStatus;
	}

	public void setListStatus(List<Statut> listStatus) {
		this.listStatus = listStatus;
	}

	public LoginManagedBean getLoginMb() {
		return loginMb;
	}

	public void setLoginMb(LoginManagedBean loginMb) {
		this.loginMb = loginMb;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public Admin getAdminConnecte() {
		return adminConnecte;
	}

	public void setAdminConnecte(Admin adminConnecte) {
		this.adminConnecte = adminConnecte;
	}

	public String getStatutSelect() {
		return statutSelect;
	}

	public void setStatutSelect(String statutSelect) {
		this.statutSelect = statutSelect;
	}

	public List<Tache> getListeTaches() {
		return listeTaches;
	}

	public void setListeTaches(List<Tache> listeTaches) {
		this.listeTaches = listeTaches;
	}

	public List<ToDo> getToDoList() {
		return toDoList;
	}

	public void setToDoList(List<ToDo> toDoList) {
		this.toDoList = toDoList;
	}

	public String getTodoPriority() {
		return todoPriority;
	}

	public void setTodoPriority(String todoPriority) {
		this.todoPriority = todoPriority;
	}

	public String getNewStatut() {
		return newStatut;
	}

	public void setNewStatut(String newStatut) {
		this.newStatut = newStatut;
	}

	public List<Type> getListPriority() {
		return listPriority;
	}

	public void setListPriority(List<Type> listPriority) {
		this.listPriority = listPriority;
	}

	public PartenaireService getPartenaireService() {
		return partenaireService;
	}

	public void setPartenaireService(PartenaireService partenaireService) {
		this.partenaireService = partenaireService;
	}

	public Offre getOffreCree() {
		return offreCree;
	}

	public void setOffreCree(Offre offreCree) {
		this.offreCree = offreCree;
	}

	public List<Partenaire> getListPartners() {
		return listPartners;
	}

	public void setListPartners(List<Partenaire> listPartners) {
		this.listPartners = listPartners;
	}

	
	public Integer getIdPartenaireSelectionne() {
		return idPartenaireSelectionne;
	}

	public void setIdPartenaireSelectionne(Integer idPartenaireSelectionne) {
		this.idPartenaireSelectionne = idPartenaireSelectionne;
	}

	public OffreService getOffreService() {
		return offreService;
	}

	public void setOffreService(OffreService offreService) {
		this.offreService = offreService;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public UtilisateurRepository getUr() {
		return ur;
	}

	public void setUr(UtilisateurRepository ur) {
		this.ur = ur;
	}

	public List<Integer> getListUtils() {
		return listUtils;
	}

	public void setListUtils(List<Integer> listUtils) {
		this.listUtils = listUtils;
	}

	public OffreManagedBean getOffreMb() {
		return offreMb;
	}

	public void setOffreMb(OffreManagedBean offreMb) {
		this.offreMb = offreMb;
	}

}
