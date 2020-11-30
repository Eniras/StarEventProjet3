package fr.isika.cdi6.starevent.web.managedbeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import fr.isika.cdi6.starevent.data.model.utilisateurs.Client;
import fr.isika.cdi6.starevent.services.ClientService;

@Named("profilClientMb")
@SessionScoped
public class ProfilClientManagedBean implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Inject
	private LoginManagedBean loginMb;
	
	@Inject
	private ClientService clientService;
	
	
	private Client clientConnecte;
	
	@PostConstruct
	public void init() {
		clientConnecte= (Client) clientService.findById(loginMb.getId());
	}

	public LoginManagedBean getLoginMb() {
		return loginMb;
	}

	public void setLoginMb(LoginManagedBean loginMb) {
		this.loginMb = loginMb;
	}

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public Client getClientConnecte() {
		return clientConnecte;
	}

	public void setClientConnecte(Client clientConnecte) {
		this.clientConnecte = clientConnecte;
	}
	
	
}
