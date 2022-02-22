package com.example.AplicacionSpring.Controller;

import com.example.AplicacionSpring.Model.Employee;
import com.example.AplicacionSpring.Model.Project;
import com.example.AplicacionSpring.Service.EmployeeService;
import com.example.AplicacionSpring.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/Project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    /**
     * Obtener todos
     */
    @GetMapping()
    public ArrayList<Project> obtenerProject() {
        return projectService.obtenerProject();
    }

    /**
     * guardar proyecto
     */
    @PostMapping()
    public Project guardarProject(@RequestBody Project project) {
        return this.projectService.guardarProject(project);
    }

    /**
     * Obtener por id
     */
    @GetMapping(path = "/{id}")
    public Optional<Project> obtenerProjectPorId(@PathVariable("id") Long id) {
        return this.projectService.obtenerProjectPorId(id);
    }

    /**
     * Eliminar proyecto
     */
    @DeleteMapping(path = "/{id}")
    public String eliminarProyectoPorId(@PathVariable("id") Long id) {
        boolean ok = this.projectService.eliminarProjectPorId(id);
        if (ok) {
            return "Se elimino el Projecto por id " + id;
        } else {
            return "No se pudo  eliminar el Proyecto con id " + id;
        }
    }

}
