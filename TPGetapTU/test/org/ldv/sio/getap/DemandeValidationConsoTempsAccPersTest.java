package org.ldv.sio.getap;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

public class DemandeValidationConsoTempsAccPersTest {
	
	private DemandeValidationConsoTempsAccPers dvctap;
	
	@Before
	public void setUp(){
		Classe classe = new Classe(0, "SIO22");
		User prof = new User(0l, "Olivier", "Capuozzo", classe, "profPrin");
		User eleve = new User(1l, "Nizar", "Ben Ragdel", classe, "eleve");
		AccPersonalise accPers = new AccPersonalise(0, "Salon du libre", 0, 0l);
		
		Date date = Date.valueOf("2012-10-07");
		
		dvctap = new DemandeValidationConsoTempsAccPers(0l, "2012-2013", date, 240, prof, accPers, eleve);
	}
	
	@Test
	public void testEtatInitial(){
		assertTrue("Etat initial", dvctap.isEtatInitial());
	}
	
	@Test
	public void testModifieeEleve(){
		dvctap.modifieeParEleve();
		assertTrue("Etat modifié élève",dvctap.getEtat() == 4 );
	}
	
	@Test
	public void testModifEleveApresValiderProfesseur(){
		dvctap.setEtat(0);
		dvctap.valideeParLeProfesseur();
		assertFalse("Etat modifié élève",dvctap.modifieeParEleve());
	}
	
	@Test
	public void testModifEleveApresRefuserProfesseur(){
		dvctap.setEtat(0);
		dvctap.refuseeParLeProfesseur();
		assertFalse("Etat modifié élève",dvctap.modifieeParEleve());
	}
	
	@Test
	public void testModifEleveApresAnnulerEleve() {
		dvctap.setEtat(0);
		dvctap.modifieeParEleve();
		dvctap.annuleeParEleve();
		dvctap.modifieeParEleve();
		assertFalse("Etat modifié élève",dvctap.modifieeParEleve());
	}
	
	@Test
	public void testDiffPassageEtat(){
		dvctap.setEtat(0);
		dvctap.modifieeParEleve();
		dvctap.valideeParLeProfesseur();
		dvctap.modifieeParEleve();
		dvctap.modifieeDureeParLeProfesseur();
		dvctap.rejeteParEleve();
		dvctap.valideeParLeProfesseur();
		System.out.println(dvctap.getEtat());
		assertFalse("Etat modifié élève",dvctap.modifieeParEleve());
	}
	
	
}
