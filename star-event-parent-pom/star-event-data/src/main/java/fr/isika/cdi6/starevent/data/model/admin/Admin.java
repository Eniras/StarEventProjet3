package fr.isika.cdi6.starevent.data.model.admin;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import fr.isika.cdi6.starevent.data.model.taches.Tache;
import fr.isika.cdi6.starevent.data.model.taches.ToDo;
import fr.isika.cdi6.starevent.data.model.utilisateurs.ProfilUtilisateur;
import fr.isika.cdi6.starevent.data.model.utilisateurs.Utilisateur;

@Entity
@DiscriminatorValue(value = "Admin")

public class Admin extends Utilisateur {
	
	@OneToOne(orphanRemoval = true, cascade =  CascadeType.ALL)
	private ProfilUtilisateur profilAdmin;

	//Bi //enlevelemap et la relation a marché
	@OneToOne(orphanRemoval = true, cascade =CascadeType.ALL, fetch = FetchType.EAGER)
	private ToDo toDo;
	
	public Admin() {
	}
	
	public void ajouterTache(Tache tache) {
		this.toDo.ajouter(tache);
	}
	
	public void retirerTache(Tache tache) {
		this.toDo.retirer(tache);
	}

	public ProfilUtilisateur getProfilAdmin() {
		return profilAdmin;
	}

	public void setProfilAdmin(ProfilUtilisateur profilAdmin) {
		this.profilAdmin = profilAdmin;
	}

	public ToDo getToDo() {
		return toDo;
	}

	public void setToDo(ToDo toDo) {
		this.toDo = toDo;
	}
	
	
}