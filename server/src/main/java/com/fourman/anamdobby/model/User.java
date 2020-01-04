package com.fourman.anamdobby.model;

import com.fourman.anamdobby.dto.DobbyResponseDto;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String naverId;

    private String name;
    private String profileFileName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order orderToClean;

    public User() {
    }

    public User(String name, String profileFileName) {
        this.name = name;
        this.profileFileName = profileFileName;
    }

    public User(String naverId, String name, String profileFileName) {
        this.naverId = naverId;
        this.name = name;
        this.profileFileName = profileFileName;
    }

    public DobbyResponseDto toDobbyResponseDto() {
        return new DobbyResponseDto(id, name, profileFileName);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNaverId() {
        return naverId;
    }

    public void setNaverId(String naverId) {
        this.naverId = naverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileFileName() {
        return profileFileName;
    }

    public void setProfileFileName(String profileFileName) {
        this.profileFileName = profileFileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", naverId='" + naverId + '\'' +
                ", name='" + name + '\'' +
                ", profileFileName='" + profileFileName + '\'' +
                ", orderToClean=" + orderToClean +
                '}';
    }
}
