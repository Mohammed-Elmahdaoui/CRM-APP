package model;

public class Facture {
  private int idFacture;
  private int idClient;
  private int idCommande;

  // Constructor
  public Facture(int idFacture, int idClient, int idCommande) {
    this.idFacture = idFacture;
    this.idClient = idClient;
    this.idCommande = idCommande;
  }

  // Getters
  public int getIdFacture() {
    return idFacture;
  }

  public int getIdClient() {
    return idClient;
  }

  public int getIdCommande() {
    return idCommande;
  }

  // Setters
  public void setIdFacture(int idFacture) {
    this.idFacture = idFacture;
  }

  public void setIdClient(int idClient) {
    this.idClient = idClient;
  }

  public void setIdCommande(int idCommande) {
    this.idCommande = idCommande;
  }

  // toString method
  @Override
  public String toString() {
    return "Facture [idFacture=" + idFacture + ", idClient=" + idClient + ", idCommande="
        + idCommande + "]";
  }
}
