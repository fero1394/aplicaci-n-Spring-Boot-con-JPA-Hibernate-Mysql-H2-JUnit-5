package com.example.AplicacionSpring.Service;

import com.example.AplicacionSpring.Model.Employee;
import com.example.AplicacionSpring.Model.Project;
import com.example.AplicacionSpring.Repository.IEmployeeJpaRepsitory;
import com.example.AplicacionSpring.Repository.IProjectJpaRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    IProjectJpaRepsitory projectRepository;

    /**
     *Devuelve un listado con todos los roles creados en la BD
     */
    public ArrayList<Project> obtenerProject(){
        return (ArrayList<Project>)projectRepository.findAll();
    }


    /**
     *Guarda el proyecto pasado por parametro en la BD
     */
    public Project guardarProject(Project project){
        return projectRepository.save(project);
    }

    /**
     *Devuelve los datos del proyecto asociado al Id pasado por
     * parametro
     */
    public Optional<Project> obtenerProjectPorId(Long id){
        return projectRepository.findById(id);
    }

    /**
     * Elimina un proyecto asociado a un id pasado por
     * parametro
     */
    public boolean eliminarProjectPorId(Long id){
        try{
            projectRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
