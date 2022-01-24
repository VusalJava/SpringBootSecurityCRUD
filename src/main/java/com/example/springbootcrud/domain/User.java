package com.example.springbootcrud.domain;


import javax.persistence.*;

@Entity
@Table(name = "users1")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email_address")
    private String emailAddress;

    public User() {
    }

    public User(long id, String name, String emailAddress){
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMailAddress() {
        return emailAddress;
    }

    public void setMailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
