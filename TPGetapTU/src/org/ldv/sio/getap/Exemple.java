package org.ldv.sio.getap;

import java.sql.Date;

public class Exemple {
	
	private static DemandeValidationConsoTempsAccPers dvctap;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Classe classe = new Classe(0, "SIO22");
		User prof = new User(0l, "Olivier", "Capuozzo", classe, "profPrin");
		User eleve = new User(1l, "Nizar", "Ben Ragdel", classe, "eleve");
		AccPersonalise accPers = new AccPersonalise(0, "Salon du libre", 0, 0l);
		
		Date date = Date.valueOf("2012-10-07");
		
		dvctap = new DemandeValidationConsoTempsAccPers(0l, "2012-2013", date, 240, prof, accPers, eleve, 0);
		
		System.out.println(dvctap.toString());
		
		
		dvctap.setEtat(0);
		System.out.println("Demande crée par l'élève : "+dvctap.getEtat());
		
		dvctap.setEtat(4);
		System.out.println("Demande modifiée par l'élève : "+dvctap.getEtat());
		
		dvctap.setEtat(32);
		System.out.println("Demande validée par le professeur : "+dvctap.getEtat());
		
		dvctap.setEtat(4);
		System.out.println("Demande modifiée par l'élève : "+dvctap.getEtat());
		
		dvctap.setEtat(2048);
		System.out.println("Durée modifiée par le professeur : "+dvctap.getEtat());
		
		dvctap.setEtat(2);
		System.out.println("Demande rejetée par l'élève : "+dvctap.getEtat());
		
		dvctap.setEtat(32);
		System.out.println("Demande validée par le professeur : "+dvctap.getEtat());
		
	}

}