package fr.isika.cdi6.starevent.web.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import fr.isika.cdi6.starevent.dao.repositories.UtilisateurRepository;
import fr.isika.cdi6.starevent.data.model.utilisateurs.Client;
import fr.isika.cdi6.starevent.data.model.utilisateurs.Utilisateur;

@Named("loginMb")
@SessionScoped
public class LoginManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UtilisateurRepository utilisateurRepository;

	private List<Utilisateur> utilisateurs;

	private String inputLogin;
	private String inputPassword;

	private static HttpSession sessionId;
	
	private static HttpSession sessionType;
	
	private static Utilisateur utilisateurEnregistre;

	// ------------------------------------------------------Prévoir dans les
	// classes user de verifier l'existence ou non d'un login
	// ------------------------------------------------------similaire avant
	// acceptation, lors de la creation

	@PostConstruct
	public void init() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		utilisateurs = new ArrayList<>();
	}

	static Integer getId() {
		// Mémoriser l'id user dans la session http
		sessionId = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		sessionId.setAttribute("idUtilisateur", utilisateurEnregistre.getIdUtilisateur());
		return (Integer) sessionId.getAttribute("idUtilisateur");

	}
	
	static String getType() {
		// Mémoriser l'id user dans la session http
		sessionType = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		sessionType.setAttribute("typeUtilisateur", utilisateurEnregistre.getTypeUtilisateur());
		return (String) sessionType.getAttribute("typeUtilisateur");

	}
	
	static Integer getIdDashboard() {
		sessionId = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		sessionId.setAttribute("idUtilisateur", utilisateurEnregistre.getIdUtilisateur());
		Client c = (Client) utilisateurEnregistre;
		return (Integer) c.getDashboardClient().getId_dashboard();

	}

	public String loginMethod() {

		utilisateurs = utilisateurRepository.findAll();

		Boolean isPresent = utilisateurs.stream().anyMatch(u -> u.getLogin().equalsIgnoreCase(inputLogin));

		if (isPresent) {

			Optional<Utilisateur> utilisateur = utilisateurs.stream()
					.filter(u -> u.getLogin().equalsIgnoreCase(inputLogin)).findFirst();

			Utilisateur utilisateurFinal = utilisateur.get();

			utilisateurEnregistre = utilisateurFinal;

			return checkPassword(utilisateurFinal);

		} else {
			return "";
		}

	}

	private String checkPassword(Utilisateur utilisateurFinal) {

		if (utilisateurFinal.getPassword().equalsIgnoreCase(inputPassword)) {
			String type = utilisateurFinal.getTypeUtilisateur();

			if (type.equalsIgnoreCase("partenaire")) {
				FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
				return "profilPartenaire.xhtml?faces-redirect=true\"";

			} else if (type.equalsIgnoreCase("admin")) {
				FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
				return "dashboardAdmin.xhtml?faces-redirect=true\"";

			} else if (type.equalsIgnoreCase("client")) {
				FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
				return "profilClient.xhtml?faces-redirect=true\"";

			} else {
				return "";
			}

		} else {
			return "";
		}
	}
	
	public String unlog() {
		this.sessionId = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		this.sessionType = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		return "login.xhtml?faces-redirect=true\"";
	}

	public UtilisateurRepository getUtilisateurRepository() {
		return utilisateurRepository;
	}

	public void setUtilisateurRepository(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public String getInputLogin() {
		return inputLogin;
	}

	public void setInputLogin(String inputLogin) {
		this.inputLogin = inputLogin;
	}

	public String getInputPassword() {
		return inputPassword;
	}

	public void setInputPassword(String inputPassword) {
		this.inputPassword = inputPassword;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Utilisateur getUtilisateurEnregistre() {
		return utilisateurEnregistre;
	}

	public void setUtilisateurEnregistre(Utilisateur utilisateurEnregistre) {
		this.utilisateurEnregistre = utilisateurEnregistre;
	}

	public static HttpSession getSessionId() {
		return sessionId;
	}

	public static void setSessionId(HttpSession sessionId) {
		LoginManagedBean.sessionId = sessionId;
	}

	public static HttpSession getSessionType() {
		return sessionType;
	}

	public static void setSessionType(HttpSession sessionType) {
		LoginManagedBean.sessionType = sessionType;
	}

	

}
