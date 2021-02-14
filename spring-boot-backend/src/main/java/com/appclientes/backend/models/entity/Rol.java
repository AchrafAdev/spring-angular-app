package com.appclientes.backend.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "authorities")//, uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "authority"})} )
public class Rol implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JoinColumn(name = "user_id", nullable = false)
    private Long user_id;

    private String authority;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;
}
