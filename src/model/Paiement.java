package model;

import java.util.Date;


public abstract class Paiement {
  private int id;
  private double montant;
  private Date date;

  // Constructor
  public Paiement(int id, double montant, Date date) {
    this.id = id;
    this.montant = montant;
    this.date = date;
  }

  // Getters
  public int getId() {
    return id;
  }

  public double getMontant() {
    return montant;
  }

  public Date getDate() {
    return date;
  }

  // Setters
  public void setId(int id) {
    this.id = id;
  }

  public void setMontant(double montant) {
    this.montant = montant;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  // Abstract method to be implemented by subclasses
  public abstract String getType();

  // toString method
  @Override
  public String toString() {
    return "Paiement [id=" + id + ", montant=" + montant + ", date=" + date + ", type=" + getType()
        + "]";
  }
}

