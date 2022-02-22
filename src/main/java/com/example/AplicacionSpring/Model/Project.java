package com.example.AplicacionSpring.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 25, nullable = false, unique = true)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project(String name){
        this.name = name;
    }

    public Project(){
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return id.equals(project.id) && name.equals(project.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
