package fbd.dao;

import fbd.model.Villano;

public class TestConnection {
	public static void main(String[] args) {
		VillanoDAOlmpl villanoDAOImpl = new VillanoDAOlmpl();
		villanoDAOImpl.createVillano(new  Villano( 1,"pule", "ddf", "Vespertino"));
		//productDAOImpl.deleteProduct(1);
	}

}
