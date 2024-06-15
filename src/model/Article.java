package model;

public class Article {
  private int id;
  private String ref;
  private String designation;
  private double prix;
  private int quantityStock;

  // Constructor
  public Article(int id, String ref, String designation, double prix, int quantityStock) {
    this.id = id;
    this.ref = ref;
    this.designation = designation;
    this.prix = prix;
    this.quantityStock = quantityStock;
  }

  // Getters
  public int getId() {
    return id;
  }

  public String getRef() {
    return ref;
  }

  public String getDesignation() {
    return designation;
  }

  public double getPrix() {
    return prix;
  }

  public int getQuantityStock() {
    return quantityStock;
  }

  // Setters
  public void setId(int id) {
    this.id = id;
  }

  public void setRef(String ref) {
    this.ref = ref;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public void setPrix(double prix) {
    this.prix = prix;
  }

  public void setQuantityStock(int quantityStock) {
    this.quantityStock = quantityStock;
  }

  // toString method
  @Override
  public String toString() {
    return "Article [id=" + id + ", ref=" + ref + ", designation=" + designation + ", prix=" + prix
        + ", quantityStock=" + quantityStock + "]";
  }
}
