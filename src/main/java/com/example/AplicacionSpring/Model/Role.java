package com.example.AplicacionSpring.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 15, nullable = false, unique = true)
    private String name;
    
    public Role(){
    }
    
    public Role(String name){
        this.name = name;
    }
    
    public Long getId(){
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id.equals(role.id) && name.equals(role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
