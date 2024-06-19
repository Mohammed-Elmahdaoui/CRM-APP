package model;

public class Facture {
  private static int MAX_ID = 0;
  private final int idFacture;
  private int idClient;
  private int idCommande;

  // Constructor
  public Facture(int idClient, int idCommande) {
    this.idFacture = ++MAX_ID;
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
