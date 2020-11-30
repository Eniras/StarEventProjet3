package fr.isika.cdi6.starevent.dao.repositories;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import fr.isika.cdi6.starevent.data.model.gestion.Contrat;
import fr.isika.cdi6.starevent.data.model.utilisateurs.Client;
import fr.isika.cdi6.starevent.data.model.utilisateurs.DashboardClient;

@Stateless
public class DashboardRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	public DashboardRepository() {
		// TODO Auto-generated constructor stub
	}

	public void create(DashboardClient dashboardClient, Integer idClient) {
		// this.entityManager.persist(dashboardClient.getEvenements());
		this.entityManager.persist(dashboardClient);
		Client client = this.entityManager.find(Client.class, idClient);
		client.setDashboardClient(dashboardClient);
		this.entityManager.merge(dashboardClient);
		this.entityManager.merge(client);
		this.entityManager.flush();
	}

	public void update(DashboardClient dashboard) {
		entityManager.merge(dashboard);
	}

	public void remove(Integer idDashboard) {
		DashboardClient dashboard = entityManager.find(DashboardClient.class, idDashboard);
		entityManager.remove(dashboard);
	}

	public DashboardClient findById(Integer idDashboard) {
		return (DashboardClient) entityManager.find(DashboardClient.class, idDashboard);
	}
}