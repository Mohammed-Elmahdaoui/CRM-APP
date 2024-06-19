package model;

import java.util.Date;


public class PaiementEspeces extends Paiement {
  private boolean effectue;

  // Constructor
  public PaiementEspeces(double montant, Date date, boolean effectue) {
    super(montant, date);
    this.effectue = effectue;
  }

  // Getter
  public boolean isEffectue() {
    return effectue;
  }

  // Setter
  public void setEffectue(boolean effectue) {
    this.effectue = effectue;
  }

  // Override the getType method
  @Override
  public String getType() {
    return "Especes";
  }

  // Override the toString method
  @Override
  public String toString() {
    return "PaiementEspeces [" + super.toString() + ", effectue=" + effectue + "]";
  }
}

