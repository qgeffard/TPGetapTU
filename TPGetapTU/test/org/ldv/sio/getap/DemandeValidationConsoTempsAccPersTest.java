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
		
		dvctap = new DemandeValidationConsoTempsAccPers(0l, "2012-2013", date, 240, prof, accPers, eleve, 0);
	}
	
	@Test
	public void testEtatInitial(){
		try{
			
			assertTrue("Etat initial", dvctap.isEtatInitial());
		}catch(DVCTAPException e){
			
		}
		
	}
	
	@Test
	public void testModifieeEleve() throws Exception{
		try{
			dvctap.modifieeParEleve();
			assertTrue("Etat modifié élève",dvctap.getEtat() == 4 );
		}catch(DVCTAPException e){
			
		}
	}
	
	@Test
	public void testValiderProfesseur() throws Exception{
		try{
			dvctap.setEtat(0);
			dvctap.valideeParLeProfesseur();
			dvctap.modifieeParEleve();
			assertTrue("Etat valider prof",dvctap.isValideeProf());
		}catch(DVCTAPException e){
			
		}
	}
	
	@Test
	public void testRefuserProfesseur() throws Exception{
		try{
			dvctap.setEtat(0);
			dvctap.refuseeParLeProfesseur();
			dvctap.modifieeParEleve();
			assertTrue("Etat refuser prof",dvctap.isRefuseeProf());
		}catch(DVCTAPException e){
			
		}
	}
	
	@Test
	public void testAnnulerEleve() throws Exception{
		try{
			dvctap.setEtat(0);
			dvctap.modifieeParEleve();
			dvctap.annuleeParEleve();
			dvctap.modifieeParEleve();
			assertTrue("Etat modifié élève",dvctap.isAnnuleeEleve());
		}catch(DVCTAPException e){
			
		}
	}
	
	@Test
	public void testDiffPassageEtat() throws Exception{
		try{
			dvctap.setEtat(0);
			dvctap.modifieeParEleve();
			dvctap.valideeParLeProfesseur();
			dvctap.modifieeParEleve();
			dvctap.modifieeDureeParLeProfesseur();
			dvctap.rejeteParEleve();
			dvctap.valideeParLeProfesseur();
			System.out.println(dvctap.getEtat());
			assertTrue("Etat modifié élève",dvctap.isValideeProf());
		}catch(DVCTAPException e){
			
		}
	}
	
	
}
