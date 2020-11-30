package fr.isika.cdi6.starevent.data.model.gestion;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import fr.isika.cdi6.starevent.data.model.enums.Statut;
import fr.isika.cdi6.starevent.data.model.utilisateurs.DashboardClient;

@Entity
@NamedQueries({
	@NamedQuery(name = "Evenement.findAll", query = "Select e from Evenement e"),
	@NamedQuery(name = "Evenement.findByIdDash", query = "Select e from Evenement e inner join e.dashboardClient as ED where ED.idDashboard =: idDashboard")
	
})
public class Evenement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_evenement;


	private LocalDate date_debut;


	private LocalDate date_fin;


	@Enumerated(EnumType.STRING)
	private Statut statut;


	private String titreEvenement;


	private Integer nbInvites;


	private BigDecimal prixTotalEvenement;

	@ManyToOne//bidir
	private DashboardClient dashboardClient;
	
//enleve le map
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "evenement", fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Reservation> reservations;

	public Evenement() {
		reservations = new ArrayList<>();
	}
	
	public void ajouterReservation(Reservation reservation) {
		this.getReservations().add(reservation);
	}

	public void retirerReservation(Reservation reservation) {
		this.getReservations().remove(reservation);
	}

	public Integer getId_evenement() {
		return id_evenement;
	}

	public void setId_evenement(Integer id_evenement) {
		this.id_evenement = id_evenement;
	}

	public LocalDate getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(LocalDate date_debut) {
		this.date_debut = date_debut;
	}

	public LocalDate getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(LocalDate date_fin) {
		this.date_fin = date_fin;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public String getTitreEvenement() {
		return titreEvenement;
	}

	public void setTitreEvenement(String titreEvenement) {
		this.titreEvenement = titreEvenement;
	}

	public Integer getNbInvites() {
		return nbInvites;
	}

	public void setNbInvites(Integer nbInvites) {
		this.nbInvites = nbInvites;
	}

	public BigDecimal getPrixTotalEvenement() {
		return prixTotalEvenement;
	}

	public void setPrixTotalEvenement(BigDecimal prixTotalEvenement) {
		this.prixTotalEvenement = prixTotalEvenement;
	}



	public DashboardClient getDashboardClient() {
		return dashboardClient;
	}

	public void setDashboardClient(DashboardClient dashboardClient) {
		this.dashboardClient = dashboardClient;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Evenement [id_evenement=");
		builder.append(id_evenement);
		builder.append(", date_debut=");
		builder.append(date_debut);
		builder.append(", date_fin=");
		builder.append(date_fin);
		builder.append(", statut=");
		builder.append(statut);
		builder.append(", titreEvenement=");
		builder.append(titreEvenement);
		builder.append(", nbInvites=");
		builder.append(nbInvites);
		builder.append(", prixTotalEvenement=");
		builder.append(prixTotalEvenement);
		builder.append("]");
		return builder.toString();
	}

}