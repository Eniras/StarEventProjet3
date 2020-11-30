package fr.isika.cdi6.starevent.data.model.utilisateurs;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import fr.isika.cdi6.starevent.data.model.gestion.Evenement;

@Entity
public class DashboardClient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idDashboard;
//bidir
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "dashboardClient", fetch = FetchType.LAZY, orphanRemoval = true)
//	@Fetch(value = FetchMode.SUBSELECT)
	private List<Evenement> evenements;


	public void ajouter(Evenement evenement) {
		this.getEvenements().add(evenement);

	}

	public void retirer(Evenement evenement) {
		this.getEvenements().remove(evenement);

	}

	public Integer getId_dashboard() {
		return idDashboard;
	}

	public void setId_dashboard(Integer id_dashboard) {
		this.idDashboard = id_dashboard;
	}

	public List<Evenement> getEvenements() {
		return evenements;
	}

	public void setEvenements(List<Evenement> evenements) {
		this.evenements = evenements;
	}



}
