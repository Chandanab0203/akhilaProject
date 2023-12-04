package com.records.criminal.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String position;

    private String email;

    private String password;
	
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "users_roles",
        joinColumns = @JoinColumn(
            name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(
            name = "role_id", referencedColumnName = "id"))

    private Collection < Role > roles;
    
    public User() {

    }
    
    public User( String position, String email, String password, Collection < Role > roles) {
        super();
        
        this.position = position;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
    
    
}
