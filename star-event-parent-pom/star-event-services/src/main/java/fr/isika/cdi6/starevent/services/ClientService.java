package fr.isika.cdi6.starevent.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cdi6.starevent.dao.repositories.ClientRepository;
import fr.isika.cdi6.starevent.dao.repositories.UtilisateurRepository;
import fr.isika.cdi6.starevent.data.model.gestion.Partenaire;
import fr.isika.cdi6.starevent.data.model.utilisateurs.Client;

@Stateless
public class ClientService {
		// TODO : pas de NEW dans JEE et CDI, il faut TOUT injecter
		@Inject
		private ClientRepository clientRepository;
		
		@Inject
		private UtilisateurRepository utilisateurRepository;
		
		
		
		public void ajouter(Client client) {
			Integer idUtilisateur = utilisateurRepository.create(client);
		
			clientRepository.create(client);
			
			client.setIdUtilisateur(idUtilisateur);
			clientRepository.update(client);

			
		}

		public void update(Client client) {
			clientRepository.update(client);
			
		}

		public void retirer(Integer idClient) {
			clientRepository.remove(idClient);
		}

		public Client findById(Integer idClient) {
			return (Client) clientRepository.findById(idClient);
		}
		
		public List<Client> findAll() {
			 List<Client> list = clientRepository.findAll();

			return list;
		}
}
