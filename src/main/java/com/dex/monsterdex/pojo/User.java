package com.dex.monsterdex.pojo;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bestmonster")
    private Monster bestMonster;

    public User() {
    }

    public User(String username, Monster bestMonster) {
        this.username = username;
        this.bestMonster = bestMonster;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Monster getBestMonster() {
        return bestMonster;
    }

    public void setBestMonster(Monster bestMonster) {
        this.bestMonster = bestMonster;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", bestMonster=" + (bestMonster != null ? bestMonster.getName() : "null") +
                '}';
    }
}
