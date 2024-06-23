package model;

import java.util.Date;


public class Paiement {
  private static int MAX_ID = 0;
  private int id;
  private double montant;
  private Date date;
  private Command command;

  // Constructor
  public Paiement(double montant, Date date) {
    this.id = ++MAX_ID;
    this.montant = montant;
    this.date = date;
  }

  // Getters
  public int getId() {
    return id;
  }
  public Command getCommand() {
    return command;
  }

  public double getMontant() {
    return montant;
  }

  public Date getDate() {
    return date;
  }

  // Setters
  public void setCommand(Command command) {
    this.command = command;
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
    return "Paiement [id=" + id + ", command=" + command + ", montant=" + montant + ", date=" + date + "]";
  }

  public void addCommand(Command command) {
    this.command=command;
  }
}

