package fr.isika.cdi6.starevent.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cdi6.starevent.dao.repositories.DashboardRepository;
import fr.isika.cdi6.starevent.data.model.utilisateurs.DashboardClient;

@Stateless
public class DashboardService {

	@Inject
	private DashboardRepository dashRepository;

	public DashboardClient findById(Integer idDashboard) {
		return dashRepository.findById(idDashboard);
	}

}
