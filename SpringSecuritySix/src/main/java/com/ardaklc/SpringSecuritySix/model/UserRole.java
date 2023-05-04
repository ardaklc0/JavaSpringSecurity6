package com.ardaklc.SpringSecuritySix.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_role_id")
    private Long user_role_id;
    private String user_role_name;

    public UserRole() {
    }

    public UserRole(String user_role_name) {
        this.user_role_name = user_role_name;
    }

    public Long getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(Long user_role_id) {
        this.user_role_id = user_role_id;
    }

    public String getUser_role_name() {
        return user_role_name;
    }

    public void setUser_role_name(String user_role_name) {
        this.user_role_name = user_role_name;
    }

    @Override
    public String toString() {
        return
                "\nUserRole{" +
                        "\nuser_role_id=" + user_role_id +
                        "\nuser_role_name='" + user_role_name +
                        "}\n";
    }
}
