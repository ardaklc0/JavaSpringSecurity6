package com.ardaklc.SpringSecuritySix.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "`user`")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id" )
    private Long user_id;
    @Column(name = "user_name", nullable = false)
    private String name;
    @Column(name = "user_password", nullable = false)
    private String user_password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_role_id", referencedColumnName = "user_role_id")
    private List<UserRole> user_roles;

    public User(String user_password, String user_name, List<UserRole> user_roles) {
        this.user_password = user_password;
        this.name = user_name;
        this.user_roles = user_roles;
    }

    public User() {
    }

    public String getUser_name() {
        return name;
    }

    public void setUser_name(String user_name) {
        this.name = user_name;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public List<UserRole> getUser_roles() {
        return user_roles;
    }

    public void setUser_role(List<UserRole> user_roles) {
        this.user_roles = user_roles;
    }

    @Override
    public String toString() {
        return
                "\nUser{" +
                        "\nuser_id=" + user_id +
                        "\nuser_name=" + name +
                        "\nuser_password='" + user_password + '\'' +
                        "\nuser_role=" + user_roles +
                        "}\n";
    }
}