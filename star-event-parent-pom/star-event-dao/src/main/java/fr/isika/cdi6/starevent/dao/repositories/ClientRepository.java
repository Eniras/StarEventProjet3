package fr.isika.cdi6.starevent.dao.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cdi6.starevent.data.model.gestion.Evenement;
import fr.isika.cdi6.starevent.data.model.gestion.Reservation;
import fr.isika.cdi6.starevent.data.model.utilisateurs.Client;

@Stateless
public class ClientRepository {

		@PersistenceContext
		private EntityManager entityManager;
//		
//		@Inject
//		private DashboardRepository dashboardRepository;

		public ClientRepository() {
		}

		public List<Client> findAll(){
			return entityManager.createNamedQuery("Client.findAll", Client.class).getResultList();
		}

		public void create(Client client) {
			
			List<Evenement> events = client.getDashboardClient().getEvenements();
			events.stream().forEach(e-> {
							List<Reservation> resa = e.getReservations();
							resa.stream().forEach(r-> {
									this.entityManager.persist(r.getEvenement());
									this.entityManager.persist(r);
												});
							this.entityManager.persist(e.getDashboardClient()); 
							this.entityManager.persist(e); 
									});
	
			this.entityManager.persist(client.getDashboardClient());
			this.entityManager.persist(client);

			this.entityManager.flush();
		}

		public void update(Client client) {
			entityManager.merge(client);
		}

		public void remove(Integer idClient) {
			Client client = entityManager.find(Client.class, idClient);
			entityManager.remove(client);
		}

		public Client findById(Integer idClient) {
			return (Client) entityManager.find(Client.class, idClient);
		}
		
}
