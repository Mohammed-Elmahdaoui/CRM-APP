package model;

import java.util.Date;


public class PaiementCarte extends Paiement {
  private String nom;
  private String type;
  private Date dateExpiration;

  // Constructor
  public PaiementCarte(int id, double montant, Date date, String nom, String type,
      Date dateExpiration) {
    super(id, montant, date);
    this.nom = nom;
    this.type = type;
    this.dateExpiration = dateExpiration;
  }

  // Getters
  public String getNom() {
    return nom;
  }

  public String getTypeCarte() {
    return type;
  }

  public Date getDateExpiration() {
    return dateExpiration;
  }

  // Setters
  public void setNom(String nom) {
    this.nom = nom;
  }

  public void setTypeCarte(String type) {
    this.type = type;
  }

  public void setDateExpiration(Date dateExpiration) {
    this.dateExpiration = dateExpiration;
  }

  // Override the getType method
  @Override
  public String getType() {
    return "Carte";
  }

  // Override the toString method
  @Override
  public String toString() {
    return "PaiementCarte [" + super.toString() + ", nom=" + nom + ", type=" + type
        + ", dateExpiration=" + dateExpiration + "]";
  }
}

