package fr.isika.cdi6.starevent.web.managedbeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import fr.isika.cdi6.starevent.data.model.enums.Statut;
import fr.isika.cdi6.starevent.data.model.gestion.Evenement;
import fr.isika.cdi6.starevent.data.model.gestion.Reservation;
import fr.isika.cdi6.starevent.data.model.offres.Offre;
import fr.isika.cdi6.starevent.services.EvenementService;
import fr.isika.cdi6.starevent.services.ReservationService;

@Named("reservationMb")
@SessionScoped
public class ReservationManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ReservationService reservationService;

	@Inject
	private EvenementService evenementService;

	@Inject
	private static LoginManagedBean loginMb;

	@Inject
	private OffreManagedBean offreMb;

	private Evenement evenementSelectionne;

	private Evenement evenementCree;

	private Integer idEvenement;

	private Reservation reservationCree;

	private Date dateSelect;

	private LocalDate date = LocalDate.of(2020, 10, 22);

	private List<Evenement> listEvenementsClient = new ArrayList<>();

	private List<Reservation> listReservationsPartenaire = new ArrayList<>();

	private List<Reservation> listReservations = new ArrayList<>();

	@PostConstruct
	public void init() {

		String type = loginMb.getType().toString();

		switch (type) {

		case "client":

			reservationCree = new Reservation();
			listEvenementsClient = evenementService.findByIdDash(loginMb.getIdDashboard());

			this.calculerPrixEvent();
			this.setStartDateEvent();
			this.setEndDateEvent();
			this.setNbGuest();
			this.setStatusEvent();
			break;
		case "partenaire":
			listReservationsPartenaire = reservationService.findByIdPartenaire(loginMb.getId());
			break;
		case "admin":
			; // "login.xhtml?faces-redirect=true\"";

		}

	}
//--------------- METHODE UTILS ------------------

	private void calculerPrixEvent() {
		BigDecimal price = new BigDecimal(0);
		List<BigDecimal> prixList = new ArrayList<>();
		listEvenementsClient.stream().forEach(e -> {
			e.setPrixTotalEvenement(calculerSommeOffres(e.getReservations()));
			evenementService.update(e);

		});
	}

	private LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	private LocalDate getDateSelect(SelectEvent e) {

		if ((e.getObject() != null) && (e.getObject() != "")) {

			dateSelect = (Date) e.getObject();
		}
		return convertToLocalDateViaInstant(dateSelect);
	}

	private void setStartDateEvent() {

		listEvenementsClient.stream().forEach(e -> {
			List<LocalDate> listDates = new ArrayList<LocalDate>();

			if (e.getReservations().size()>0) {

				e.getReservations().stream().forEach(r -> {

					listDates.add(r.getDate_debut());
				});
				e.setDate_debut(Collections.min(listDates));
			}
		});
	}

	private void setEndDateEvent() {

		listEvenementsClient.stream().forEach(e -> {
			List<LocalDate> listDates = new ArrayList<LocalDate>();

			if (e.getReservations().size()>0) {
				e.getReservations().stream().forEach(r -> {

					listDates.add(r.getDate_fin());
				});
				e.setDate_fin(Collections.max(listDates));
			}
		});
	}

	private void setStatusEvent() {

		listEvenementsClient.stream().forEach(e -> {
			List<Statut> listStatus = new ArrayList<>();

			if (e.getReservations().size()>0) {
				e.getReservations().stream().forEach(r -> {

					listStatus.add(r.getStatutReservation());
				});
				Boolean pending = listStatus.stream().anyMatch(s -> s == Statut.EN_ATTENTE_VALIDATION);
				if (!pending) {
					e.setStatut(Statut.EN_COURS);
				}
			}
		});
	}

	private void setNbGuest() {

		listEvenementsClient.stream().forEach(e -> {
			List<Integer> nbInvites = new ArrayList<>();
			if (e.getReservations().size()>1) {

				e.getReservations().stream().forEach(r -> {

					nbInvites.add(r.getNbInvites());
				});
				e.setNbInvites(Collections.max(nbInvites));
			}
		});
	}

	public BigDecimal calculerSommeOffres(List<Reservation> resa) {

		List<BigDecimal> prixList = new ArrayList<>();
		resa.forEach(offre -> {
			prixList.add(offre.getOffre().getPrixOffre());
		});

		BigDecimal prixTotal = new BigDecimal(0);

		for (BigDecimal bd : prixList) {
			prixTotal = prixTotal.add(bd);
		}

		return prixTotal;
	}

//--------------- CREER EVENT ------------------
	public String creerEvent() {
		evenementCree = new Evenement();
		evenementCree.setStatut(Statut.EN_ATTENTE_VALIDATION);
		evenementService.ajouter(evenementCree, loginMb.getIdDashboard());
		return "newEvent.xhtml?faces-redirect=true\"";

	}

//	public void affecterTitreEvenement(ValueChangeEvent e) {
//		String titre = e.getNewValue().toString();
//		evenementCree.setTitreEvenement(titre);
//		evenementService.update(evenementCree);
//	}
//
//	public void affecterNbGuestEvenement(ValueChangeEvent e) {
//
//		if ((e.getNewValue() != null) && (e.getNewValue() != "") && (e.getOldValue() != null)
//				&& (e.getOldValue() != "")) {
//			Integer nbGuest = Integer.parseInt(e.getNewValue().toString());
//			evenementCree.setNbInvites(nbGuest);
//			evenementService.update(evenementCree);
//		}
//	}

	public void selectDateDebutEvent(SelectEvent e) {

		evenementCree.setDate_debut(this.getDateSelect(e));
		evenementService.update(evenementCree);

	}

	public void selectDateFinEvent(SelectEvent e) {
		evenementCree.setDate_fin(this.getDateSelect(e));
		evenementService.update(evenementCree);
	}

	public void affecterEvenement(Evenement evenement) {
		// Equivalent setEvent car sinon impossible d'appeler depuis le xhtml
		this.evenementSelectionne = evenement;
	}

	public void update() {
		evenementService.update(evenementCree);
		this.listEvenementsClient.add(evenementCree);
		evenementCree= new Evenement();

	}

//--------------- CREER RESERVATION ------------------

	public void selectDateDebutReservation(SelectEvent e) {

		reservationCree.setDate_debut(this.getDateSelect(e));

	}

	public void selectDateFinReservation(SelectEvent e) {

		reservationCree.setDate_fin(this.getDateSelect(e));

	}

//	public void affecterNbGuestReservation(ValueChangeEvent e) {
//		if ((e.getNewValue() != null) && (e.getNewValue() != "") && (e.getOldValue() != null)
//				&& (e.getOldValue() != "")) {
//			Integer nbGuest = Integer.parseInt(e.getNewValue().toString());
//			reservationCree.setNbInvites(nbGuest);
//		}
//	}

	public void bookOffer() {

		reservationCree.setOffre(offreMb.getOffreSelectionnee());
		reservationCree.setPartenaire(offreMb.getOffreSelectionnee().getPartenaire());
		reservationCree.setStatutReservation(Statut.EN_ATTENTE_VALIDATION);

		Evenement evenement = evenementService.findById(idEvenement);
		reservationCree.setEvenement(evenement);

		reservationService.ajouter(reservationCree, offreMb.getOffreSelectionnee().getIdOffre());
		evenement.getReservations().add(reservationCree);
		evenementService.update(evenement);

		this.listEvenementsClient = evenementService.findByIdDash(loginMb.getIdDashboard());
		this.calculerPrixEvent();
		this.setStartDateEvent();
		this.setEndDateEvent();
		this.setNbGuest();

		this.setStatusEvent();
		this.listEvenementsClient = evenementService.findByIdDash(loginMb.getIdDashboard());
		reservationCree = new Reservation();
	}

	public List<Reservation> listReservationsEnAttente() {
		List<Reservation> listAttente = listReservationsPartenaire.stream()
				.filter(r -> r.getStatutReservation().equals(Statut.EN_ATTENTE_VALIDATION))
				.collect(Collectors.toList());
		return listAttente;

	}

	public List<Reservation> listReservationsEnCours() {
		List<Reservation> listEnCours = listReservationsPartenaire.stream()
				.filter(r -> r.getStatutReservation().equals(Statut.EN_COURS)
						|| r.getStatutReservation().equals(Statut.TERMINE))
				.collect(Collectors.toList());
		return listEnCours;

	}

	public void validReservation(Reservation reservation) {

		reservation.setStatutReservation(Statut.EN_COURS);
		reservationService.update(reservation);
	}

	public void deleteReservation(Reservation reservation) {
		// On conserve la reservation en base de données avec un statut ANNULE
		reservation.setStatutReservation(Statut.ANNULE);
		reservationService.update(reservation);
	}

	public String listEvenements() {
		return "evenements.xhtml?faces-redirect=true\"";
	}

	public void detailReservations(Integer idEvenement) {
		listReservations = reservationService.findByIdEvenement(idEvenement);
	}

	public ReservationService getReservationService() {
		return reservationService;
	}

	public void setReservationService(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public EvenementService getEvenementService() {
		return evenementService;
	}

	public void setEvenementService(EvenementService evenementService) {
		this.evenementService = evenementService;
	}

	public static LoginManagedBean getLoginMb() {
		return loginMb;
	}

	public static void setLoginMb(LoginManagedBean loginMb) {
		ReservationManagedBean.loginMb = loginMb;
	}

	public List<Evenement> getListEvenementsClient() {
		return listEvenementsClient;
	}

	public void setListEvenementsClient(List<Evenement> listEvenementsClient) {
		this.listEvenementsClient = listEvenementsClient;
	}

	public List<Reservation> getListReservationsPartenaire() {
		return listReservationsPartenaire;
	}

	public void setListReservationsPartenaire(List<Reservation> listReservationsPartenaire) {
		this.listReservationsPartenaire = listReservationsPartenaire;
	}

	public List<Reservation> getListReservations() {
		return listReservations;
	}

	public void setListReservations(List<Reservation> listReservations) {
		this.listReservations = listReservations;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Evenement getEvenementSelectionne() {
		return evenementSelectionne;
	}

	public void setEvenementSelectionne(Evenement evenementSelectionne) {
		this.evenementSelectionne = evenementSelectionne;
	}

	public Evenement getEvenementCree() {
		return evenementCree;
	}

	public void setEvenementCree(Evenement evenementCree) {
		this.evenementCree = evenementCree;
	}

	public Date getDateSelect() {
		return dateSelect;
	}

	public void setDateSelect(Date dateSelect) {
		this.dateSelect = dateSelect;
	}

	public OffreManagedBean getOffreMb() {
		return offreMb;
	}

	public void setOffreMb(OffreManagedBean offreMb) {
		this.offreMb = offreMb;
	}

	public Integer getIdEvenement() {
		return idEvenement;
	}

	public void setIdEvenement(Integer idEvenement) {
		this.idEvenement = idEvenement;
	}

	public Reservation getReservationCree() {
		return reservationCree;
	}

	public void setReservationCree(Reservation reservationCree) {
		this.reservationCree = reservationCree;
	}

}
