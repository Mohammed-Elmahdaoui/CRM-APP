package model;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;


public class Commande {
  private int id;
  private List<Integer> commandItemIds;
  private double total;
  private Date date;

  // Constructor
  public Commande(int id, Date date) {
    this.id = id;
    this.date = date;
    this.commandItemIds = new ArrayList<>();
    this.total = 0.0;
  }
  public Commande(int id, List<Integer> commandItemIds, double total, Date date) {
    this.id = id;
    this.commandItemIds = commandItemIds;
    this.total = total;
    this.date = date;
  }

  // Getters
  public int getId() {
    return id;
  }

  public List<Integer> getCommandItemIds() {
    return commandItemIds;
  }

  public double getTotal() {
    return total;
  }

  public Date getDate() {
    return date;
  }

  // Setters
  public void setId(int id) {
    this.id = id;
  }

  public void setCommandItemIds(List<Integer> commandItemIds) {
    this.commandItemIds = commandItemIds;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  // Methods to add and remove command items
  public void addCommandItem(int commandItemId, double itemPrice) {
    commandItemIds.add(commandItemId);
    total += itemPrice;
  }

  public void removeCommandItem(int commandItemId, double itemPrice) {
    if (commandItemIds.remove((Integer) commandItemId)) {
      total -= itemPrice;
    }
  }

  // toString method
  @Override
  public String toString() {
    return "Commande [id=" + id + ", commandItemIds=" + commandItemIds + ", total=" + total
        + ", date=" + date + "]";
  }
}


