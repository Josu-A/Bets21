package domain;

import javax.persistence.Entity;

// testing commets

@Entity
public class Admin extends Erabiltzaile {

	
	public Admin(String pUserName, String pIzena, String pAbizena, String pPasahitza, int pAdina, String pPostaElektro) {
		super(pUserName, pIzena, pAbizena, pPasahitza, pAdina, pPostaElektro);
	}
	
}
