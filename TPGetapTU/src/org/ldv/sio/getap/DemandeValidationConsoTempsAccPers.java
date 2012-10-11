package org.ldv.sio.getap;

import java.sql.Date;

/**
 * Demande de validation d'un temps d'accompagnement personnalisé
 * 
 * Commit pour tuto
 */

public class DemandeValidationConsoTempsAccPers {
	private static final int INITIAL = 0;
	private static final int ACCEPTEE_ELEVE = 1;
	private static final int REJETEE_ELEVE = 2;
	private static final int MODIFIEE_ELEVE = 4;
	private static final int ANNULEE_ELEVE = 8;
	private static final int VALIDEE_PROF = 32;
	private static final int REFUSEE_PROF = 64;
	private static final int DATE_MODIFIEE = 1024;
	private static final int DUREE_MODIFIEE = 2048;
	private static final int AP_MODIFIEE = 4096;

	/**
	 * Identifiant de la DCTAP
	 */
	private Long id;
	/**
	 * Année scolaire de la demande, par exemple "2011-2012"
	 */
	private String anneeScolaire;
	/**
	 * Date de réalisation de l'accompagnement
	 * 
	 */
	private java.sql.Date dateAction;
	/**
	 * Nombre de minutes d'accompagnement personnalisé à valider
	 */
	private Integer minutes;
	/**
	 * Professeur ayant assuré l'accompagnement personnalisé
	 */
	private User prof;
	/**
	 * Nature de l'accompagnement personnalisé associé à la demande
	 */
	private AccPersonalise accPers;
	/**
	 * Identifiant de l'élève ayant réalisé l'accompagnement personnalisé
	 */
	private User eleve;

	/**
	 * 
	 */
	private int etat;

	/**
	 * constructeur par défaut
	 */
	public DemandeValidationConsoTempsAccPers() {

	}

	/**
	 * Constructeur permettant de créer une demande complète.
	 * 
	 * @param id
	 *            peut être null (moment de la creation)
	 * 
	 * @param anneeScolaire
	 * @param date
	 * @param minutes
	 * @param prof
	 * @param accPers
	 * @param eleve
	 * @param etat
	 */
	public DemandeValidationConsoTempsAccPers(Long id, String anneeScolaire,
			Date date, Integer minutes, User prof, AccPersonalise accPers,
			User eleve, int etat) {
		super();
		this.id = id;
		this.anneeScolaire = anneeScolaire;
		this.dateAction = date;
		this.minutes = minutes;
		this.prof = prof;
		this.accPers = accPers;
		this.eleve = eleve;
		this.etat = etat;
	}

	// isser
	
	/**
	 * Test si l'état est initial
	 * 
	 * @return un booléen correspondant à cet état 
	 */
	public boolean isEtatInitial() {
		boolean bool = false;
		if (this.etat == INITIAL) {
			bool = true;
		}
		return bool;
	}
	
	/**
	 * Test si l'état est validé par le professeur
	 * 
	 * @return un booléen correspondant à cet état 
	 */
	public boolean isValideeProf() {
		boolean bool = false;
		if ((this.etat & VALIDEE_PROF) != 0) {
			bool = true;
		}
		return bool;
	}
	
	/**
	 * Test si l'état est refusé par le professeur
	 * 
	 * @return un booléen correspondant à cet état 
	 */
	public boolean isRefuseeProf() {
		boolean bool = false;
		if ((this.etat & REFUSEE_PROF) != 0) {
			bool = true;
		}
		return bool;
	}
	
	/**
	 * Test si l'état est annulé par l'élève
	 * 
	 * @return un booléen correspondant à cet état 
	 */
	public boolean isAnnuleeEleve() {
		boolean bool = false;
		if ((this.etat & ANNULEE_ELEVE) != 0) {
			bool = true;
		}
		return bool;
	}
	
	/**
	 * Test si l'état est modifié par l'élève
	 * 
	 * @return un booléen correspondant à cet état 
	 */
	public boolean isModifieeEleve() {
		boolean bool = false;
		if ((this.etat & MODIFIEE_ELEVE) != 0) {
			bool = true;
		}
		return bool;
	}

	/**
	 * Test si l'état est accepté par l'élève
	 * 
	 * @return un booléen correspondant à cet état 
	 */
	public boolean isAccepteeEleve() {
		boolean bool = false;
		if ((this.etat & ACCEPTEE_ELEVE) != 0) {
			bool = true;
		}
		return bool;
	}

	/**
	 * Test si l'état est rejeté par l'élève
	 * 
	 * @return un booléen correspondant à cet état 
	 */
	public boolean isRejeteeEleve() {
		boolean bool = false;
		if ((this.etat & REJETEE_ELEVE) != 0) {
			bool = true;
		}
		return bool;
	}

	/**
	 * Test si l'état du bit sur la date est modifié par le professeur
	 * 
	 * @return un booléen correspondant à cet état 
	 */
	public boolean isModifieeDateProf() {
		boolean bool = false;
		if ((this.etat & DATE_MODIFIEE) != 0) {
			bool = true;
		}
		return bool;
	}

	/**
	 * Test si l'état du bit sur la durée est modifié par le professeur
	 * 
	 * @return un booléen correspondant à cet état 
	 */
	public boolean isModifieeDureeProf() {
		boolean bool = false;
		if ((this.etat & DUREE_MODIFIEE) != 0) {
			bool = true;
		}
		return bool;
	}

	/**
	 * Test si l'état du bit sur l'AP est modifié par le professeur
	 * 
	 * @return un booléen correspondant à cet état 
	 */
	public boolean isModifieeApProf() {
		boolean bool = false;
		if ((this.etat & AP_MODIFIEE) != 0) {
			bool = true;
		}
		return bool;
	}

	// getter/setter
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnneeScolaire() {
		return anneeScolaire;
	}

	public void setAnneeScolaire(String anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}

	public java.sql.Date getDateAction() {
		return dateAction;
	}

	public void setDateAction(java.sql.Date date) {
		this.dateAction = date;
	}

	public Integer getMinutes() {
		return minutes;
	}

	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}

	public User getProf() {
		return prof;
	}

	public void setProf(User prof) {
		this.prof = prof;
	}

	public AccPersonalise getAccPers() {
		return accPers;
	}

	public void setAccPers(AccPersonalise accPers) {
		this.accPers = accPers;
	}

	public User getEleve() {
		return eleve;
	}

	public void setEleve(User eleve) {
		this.eleve = eleve;
	}

	public int getEtat() {
		return etat;
	}

	/**
	 * Permet de modifier l'état de la demande
	 * 
	 * @param etat
	 *            prend ses valeur dans :
	 *            <ul>
	 *            <li>0 - demande créée par l'élève</li>
	 *            <li>1 - demande acceptée par l'élève aprés modification du
	 *            professeur</li>
	 *            <li>2 - demande rejetée par l'élève aprés modification du
	 *            professeur</li>
	 *            <li>4 - demande modifiée par l'élève</li>
	 *            <li>8 - demande annulée par l'élève</li>
	 *            <li>32 - demande validée par le professeur</li>
	 *            <li>64 - demande refusée par le professeur</li>
	 *            <li>1024 - demande où la date a été modifiée par le professeur
	 *            </li>
	 *            <li>2048 - demande où la durée a été modifiée par le
	 *            professeur</li>
	 *            <li>4096 - demande où l'accompagnement personnalisé a été
	 *            modifiée par le professeur</li>
	 *            </ul>
	 */
	public void setEtat(int etat) {
		this.etat = etat;
	}

	//Méthodes
	
	public String errorReporting(){
		String str = "";
		if(this.isAnnuleeEleve())
			str = "La demande a déjà été annulée par l'élève";
		else if(this.isRefuseeProf())
			str = "La demande a déjà été refusée par le professeur";
		else if(this.isAccepteeEleve())
			str = "La demande a déjà été acceptée par l'élève";
		else if(this.isRejeteeEleve())
			str = "La demande a déjà été rejetée par l'élève";
		else if(this.isValideeProf())
			str = "La demande a déjà été validée par le professeur";
		else if(this.isModifieeApProf() || this.isModifieeDateProf() || this.isModifieeDureeProf())
			str = "La demande a déjà été modifiée par le professeur";
		else if(this.isModifieeEleve())
			str = "La demande a déjà été modifiée par l'élève";
		
		return str;
	}
	
	/**
	 * Lève le bit de validation par le professeur en fonction de l'état en cour
	 * @throws Exception 
	 */
	public void valideeParLeProfesseur() throws Exception {
		if (!this.isAnnuleeEleve() && !this.isRefuseeProf()
				&& !this.isAccepteeEleve() && !this.isRejeteeEleve()
				&& !this.isValideeProf()) {
			this.etat = this.etat | VALIDEE_PROF;
		}else{
			throw new Exception(errorReporting());
		}
	}

	/**
	 * Lève le bit de refus par le professeur en fonction de l'état en cour
	 * @throws Exception 
	 */
	public void refuseeParLeProfesseur() throws Exception {
		if (!this.isAnnuleeEleve() && !this.isValideeProf()
				&& !this.isAccepteeEleve() && !this.isRejeteeEleve()
				&& !this.isRefuseeProf()) {
			this.etat = this.etat | REFUSEE_PROF;
		}else{
			throw new Exception(errorReporting());
		}
	}

	/**
	 * Lève le bit d'annulation par l'élève en fonction de l'état en cour
	 * @throws Exception 
	 */
	public void annuleeParEleve() throws Exception {
		if (!this.isValideeProf() && !this.isRefuseeProf()
				&& !this.isAccepteeEleve() && !this.isRejeteeEleve()
				&& !this.isModifieeApProf() && !this.isModifieeDureeProf()
				&& !this.isModifieeDateProf()
				&& !this.isAnnuleeEleve()) {
			this.etat = this.etat | ANNULEE_ELEVE;
		}else{
			throw new Exception(errorReporting());
		}
	}

	/**
	 * Lève le bit de modification par l'élève en fonction de l'état en cour
	 * @throws Exception 
	 */
	public void modifieeParEleve() throws Exception {
		if (!this.isValideeProf() && !this.isRefuseeProf()
				&& !this.isAccepteeEleve() && !this.isRejeteeEleve()
				&& !this.isModifieeApProf() && !this.isModifieeDureeProf()
				&& !this.isModifieeDateProf() && !this.isAnnuleeEleve()) {
			this.etat = this.etat | MODIFIEE_ELEVE;
		}else{
			throw new Exception(errorReporting());
		}
	}

	/**
	 * Lève le bit de modification de la date par le professeur en fonction de l'état en cour
	 * @throws Exception 
	 */
	public void modifieeDateParLeProfesseur() throws Exception {
		if (!this.isValideeProf() && !this.isRefuseeProf()
				&& !this.isAccepteeEleve() && !this.isRejeteeEleve()
				&& !this.isAnnuleeEleve() && !this.isRefuseeProf()
				&& !this.isValideeProf()) {
			this.etat = this.etat | DATE_MODIFIEE;
		}else{
			throw new Exception(errorReporting());
		}
	}

	/**
	 * Lève le bit de modification de la durée par le professeur en fonction de l'état en cour
	 * @throws Exception 
	 */
	public void modifieeDureeParLeProfesseur() throws Exception {
		if (!this.isValideeProf() && !this.isRefuseeProf()
				&& !this.isAccepteeEleve() && !this.isRejeteeEleve()
				&& !this.isAnnuleeEleve() && !this.isRefuseeProf()
				&& !this.isValideeProf()) {
			this.etat = this.etat | DUREE_MODIFIEE;
		}else{
			throw new Exception(errorReporting());
		}
	}

	/**
	 * Lève le bit de modification de l'AP par le professeur en fonction de l'état en cour
	 * @throws Exception 
	 */
	public void modifieeAPParLeProfesseur() throws Exception {
		if (!this.isValideeProf() && !this.isRefuseeProf()
				&& !this.isAccepteeEleve() && !this.isRejeteeEleve()
				&& !this.isAnnuleeEleve() && !this.isRefuseeProf()
				&& !this.isValideeProf()) {
			this.etat = this.etat | AP_MODIFIEE;
		}else{
			throw new Exception(errorReporting());
		}
	}

	/**
	 * Lève le bit de rejet par l'élève en fonction de l'état en cour
	 * @throws Exception 
	 */
	public void rejeteParEleve() throws Exception {
		if (!this.isValideeProf()
				&& !this.isRefuseeProf()
				&& !this.isAccepteeEleve()
				&& !this.isAnnuleeEleve()
				&& !this.isRefuseeProf()
				&& !this.isValideeProf()
				&& !this.isRejeteeEleve()
				&& (this.isModifieeApProf() || this.isModifieeDateProf() || this
						.isModifieeDureeProf())) {
			this.etat = this.etat | REJETEE_ELEVE;
		}else{
			throw new Exception(errorReporting());
		}
	}

	/**
	 * Lève le bit d'acceptation par l'élève en fonction de l'état en cour
	 * @throws Exception 
	 */
	public void accepteeParEleve() throws Exception {
		if (!this.isValideeProf()
				&& !this.isRefuseeProf()
				&& !this.isRejeteeEleve()
				&& !this.isAnnuleeEleve()
				&& !this.isRefuseeProf()
				&& !this.isValideeProf()
				&& !this.isAccepteeEleve()
				&& (this.isModifieeApProf() || this.isModifieeDateProf() || this
						.isModifieeDureeProf())) {
			this.etat = this.etat | ACCEPTEE_ELEVE;
		}else{
			throw new Exception(errorReporting());
		}
	}

	@Override
	public String toString() {
		return "DemandeConsoTempsAccPers [id=" + id + ", anneeScolaire="
				+ anneeScolaire + ", dateAction=" + dateAction + ", minutes="
				+ minutes + ", prof=" + prof + ", accPers=" + accPers
				+ ", eleve=" + eleve + ", etat=" + etat + "]";
	}

}
