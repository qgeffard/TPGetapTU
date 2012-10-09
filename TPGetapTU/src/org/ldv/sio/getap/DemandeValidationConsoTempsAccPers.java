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

	public boolean isEtatInitial() {
		boolean bool = false;
		if (this.etat == 0) {
			bool = true;
		}
		return bool;
	}

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
	 *            <li>1024 - demande où la date a été modifiée par le
	 *            professeur</li>
	 *            <li>2048 - demande où la durée a été modifiée par le
	 *            professeur</li>
	 *            <li>4096 - demande où l'accompagnement personnalisé a été
	 *            modifiée par le professeur</li>
	 *            </ul>
	 */
	public void setEtat(int etat) {
		this.etat = etat;
	}

	// fonctions de transitions
	// INITIAL = 0;
	// ACCEPTEE_ELEVE = 1;
	// REJETEE_ELEVE = 2;
	// MODIFIEE_ELEVE = 4;
	// ANNULEE_ELEVE = 8;
	// VALIDEE_PROF = 32;
	// REFUSEE_PROF = 64;
	// DATE_MODIFIEE = 1024;
	// DUREE_MODIFIEE = 2048;
	// AP_MODIFIEE = 4096;

	public void valideeParLeProfesseur() {
		if ((this.etat & INITIAL) != 0 || (this.etat & MODIFIEE_ELEVE) != 0) {
			this.etat += VALIDEE_PROF;
		}
	}

	public void refuseeParLeProfesseur() {
		if ((this.etat & INITIAL) != 0 || (this.etat & MODIFIEE_ELEVE) != 0) {
			this.etat += REFUSEE_PROF;
		}
	}

	public void annuleeParEleve() {
		if ((this.etat & INITIAL) != 0 || (this.etat & MODIFIEE_ELEVE) != 0) {
			this.etat += ANNULEE_ELEVE;
		}
	}

	public void modifieeParEleve() {
		if ((this.etat & INITIAL) != 0 || (this.etat & MODIFIEE_ELEVE) != 0) {
			this.etat += MODIFIEE_ELEVE;
		}
	}

	public void modifieeDateParLeProfesseur() {
		if ((this.etat & INITIAL) != 0 || (this.etat & MODIFIEE_ELEVE) != 0) {
			this.etat += DATE_MODIFIEE; // Je ne pense pas que ces tests soient
										// utiles, autant partir sur des
										// methodes diff�rentes.
										// if(/*date modif*/);//TODO
										// this.etat += DATE_MODIFIEE;
										// if(/*duree modif*/);//TODO
										// this.etat += DUREE_MODIFIEE;
										// if(/*AP modif*/);//TODO
										// this.etat += AP_MODIFIEE;
		}
	}

	public void modifieeDureeParLeProfesseur() {
		if ((this.etat & INITIAL) != 0 || (this.etat & MODIFIEE_ELEVE) != 0) {
			this.etat += DUREE_MODIFIEE;
		}
	}

	public void modifieeAPParLeProfesseur() {
		if ((this.etat & INITIAL) != 0 || (this.etat & MODIFIEE_ELEVE) != 0) {
			this.etat += AP_MODIFIEE;
		}
	}

	public void rejeteParEleve() {
		if ((this.etat & DATE_MODIFIEE) != 0
				|| (this.etat & DUREE_MODIFIEE) != 0
				|| (this.etat & AP_MODIFIEE) != 0) {
			this.etat += REJETEE_ELEVE;
		}
	}

	public void accepteeParEleve() {
		if ((this.etat & DATE_MODIFIEE) != 0
				|| (this.etat & DUREE_MODIFIEE) != 0
				|| (this.etat & AP_MODIFIEE) != 0) {
			this.etat += ACCEPTEE_ELEVE;
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
