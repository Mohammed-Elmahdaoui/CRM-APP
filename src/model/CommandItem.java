package model;

public class CommandItem {
  private int id;
  private double quantity;
  private int idArticle;

  // Constructor
  public CommandItem(int id, int idArticle, double quantity) {
      this.id = id;
      this.idArticle = idArticle;
      this.quantity = quantity;
  }

  // Getters
  public int getId() {
      return id;
  }

  public double getQuantity() {
      return quantity;
  }

  public int getIdArticle() {
      return idArticle;
  }

  // Setters
  public void setId(int id) {
      this.id = id;
  }

  public void setQuantity(double quantity) {
      this.quantity = quantity;
  }

  public void setIdArticle(int idArticle) {
      this.idArticle = idArticle;
  }

  // toString method
  @Override
  public String toString() {
      return "CommandItem [id=" + id + ", idArticle=" + idArticle + ", quantity=" + quantity + "]";
  }
}
