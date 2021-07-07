package com.example.TodoAPI.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Todo")
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name="content")
  private String content;

  @Column(name = "done")
  private boolean done;

  @Column(name="deadline")
  private Date deadline;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public boolean isDone() {
    return done;
  }

  public void setDone(boolean done) {
    this.done = done;
  }

  public Date getDeadline() {
    return deadline;
  }

  public void setDeadline(Date deadline) {
    this.deadline = deadline;
  }



}
