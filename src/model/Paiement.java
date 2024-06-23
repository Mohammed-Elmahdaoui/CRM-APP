package model;

import java.util.Date;


public class Paiement {
  private static int MAX_ID = 0;
  private int id;
  private double montant;
  private Date date;
  private int commandId;

  // Constructor
  public Paiement(int commandId, double montant, Date date) {
    this.id = ++MAX_ID;
    this.commandId = commandId;
    this.montant = montant;
    this.date = date;
  }

  // Getters
  public int getId() {
    return id;
  }
  public int getCommandId() {
    return commandId;
  }

  public double getMontant() {
    return montant;
  }

  public Date getDate() {
    return date;
  }

  // Setters
  public void setCommandId(int commandId) {
    this.commandId = commandId;
  }
  
  public void setMontant(double montant) {
    this.montant = montant;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  // toString method
  @Override
  public String toString() {
    return "Paiement [id=" + id + ", commandId=" + commandId + ", montant=" + montant + ", date=" + date + "]";
  }
}

