package com.example.AplicacionSpring.Controller;

import com.example.AplicacionSpring.Model.Role;
import com.example.AplicacionSpring.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    /**
     *Obtener todos
     */
    @GetMapping()
    public ArrayList<Role> obtenerRoles(){
        return roleService.obtenerRoles();
    }

    /**
     *Guardar role
     */
    @PostMapping()
    public Role guardarRole(@RequestBody Role nombre){
        return this.roleService.guardarRole(nombre);
    }

    /**
     * Obtener por id
     */
    @GetMapping(path = "/{id}")
    public Optional<Role> obtenerRolePorId(@PathVariable("id") Long id){
        return this.roleService.obtenerRolePorId(id);
    }

    /**
     * Eliminar role
     */
    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.roleService.eliminarRolePorId(id);
        if(ok){
            return "Se elimino el Role por id "+ id;
        }else{
            return "No se pudo  eliminar el Role con id "+id;
        }

    }

}
