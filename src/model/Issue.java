package model;

import java.util.Date;

public class Issue {
  private static int MAX_ID = 0;
  private int id;
  private String detail;
  private Date createdAt;
  private String feedback;
  private String status;
  private int customerId;

  // Constructor
  public Issue(int customerId, String detail, Date createdAt, String feedback, String status) {
    this.id = ++MAX_ID;
    this.customerId = customerId;
    this.detail = detail;
    this.createdAt = createdAt;
    this.feedback = feedback;
    this.status = status;
  }

  // Getters and Setters
  public int getId() {
    return id;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public String getFeedback() {
    return feedback;
  }

  public void setFeedback(String feedback) {
    this.feedback = feedback;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public int getCustomerId() {
    return customerId;
  }

  public void setCustomerId(int customerId) {
    this.customerId = customerId;
  }

  @Override
  public String toString() {
    return "Issue{" + "id=" + id + ", detail='" + detail + '\'' + ", createdAt=" + createdAt
        + ", feedback='" + feedback + '\'' + ", status='" + status + '\'' + ", customerId="
        + customerId + '}';
  }
}
