package com.example.AplicacionSpring.Repository;

import com.example.AplicacionSpring.Model.Project;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface IProjectJpaRepsitory extends JpaRepository<Project,Long> {

}
