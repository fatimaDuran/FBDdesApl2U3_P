package fbd.dao;

import java.util.List;

import fbd.model.Villano;

public interface VillanoDAO {
	void createVillano(Villano villano);
	Villano readVillano(int id);
	List<Villano> readAllVillanos();
	void updateVillano(Villano villano);
	void deleteVillano(int id);
	

}
