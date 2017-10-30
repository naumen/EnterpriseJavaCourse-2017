package ru.matmex.welcome.model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "api_request")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="title")
    private String title;
    @Column(name="message")
    private String message;
    @Column(name="create_date")
    private Date create;

    public Message() {
    }

    public Message(int id, String title, String message, Date create) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.create = create;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }
}




