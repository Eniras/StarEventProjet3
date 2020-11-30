package fr.isika.cdi6.starevent.data.model.utilisateurs;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import fr.isika.cdi6.starevent.data.model.gestion.Evenement;

@Entity
@DiscriminatorValue(value = "Client")
@NamedQuery(name="Client.findAll", query="select c from Client c")
public class Client extends Utilisateur {

	//@NotNull
	@OneToOne(orphanRemoval = true, cascade = { CascadeType.REFRESH })
	private ProfilUtilisateur profilClient;

	@OneToOne //uni
	private DashboardClient dashboardClient;

	public Client() {
	}

	public void ajouter(Evenement evenement) {
		this.getDashboardClient().ajouter(evenement);
	}
	
	public void retirer(Evenement evenement) {
		this.getDashboardClient().retirer(evenement);
	}
	public ProfilUtilisateur getProfilClient() {
		return profilClient;
	}

	public void setProfilClient(ProfilUtilisateur profilClient) {
		this.profilClient = profilClient;
	}

	public DashboardClient getDashboardClient() {
		return dashboardClient;
	}

	public void setDashboardClient(DashboardClient dashboardClient) {
		this.dashboardClient = dashboardClient;
	}


}
