package model;

import java.util.Date;


public class PaiementCheque extends Paiement {
  private String nom;
  private int idBank;

  // Constructor
  public PaiementCheque(double montant, Date date, String nom, int idBank) {
    super(montant, date);
    this.nom = nom;
    this.idBank = idBank;
  }

  // Getters
  public String getNom() {
    return nom;
  }

  public int getIdBank() {
    return idBank;
  }

  // Setters
  public void setNom(String nom) {
    this.nom = nom;
  }

  public void setIdBank(int idBank) {
    this.idBank = idBank;
  }

  // Override the getType method
  @Override
  public String getType() {
    return "Cheque";
  }

  // Override the toString method
  @Override
  public String toString() {
    return "PaiementCheque [" + super.toString() + ", nom=" + nom + ", idBank=" + idBank + "]";
  }
}

