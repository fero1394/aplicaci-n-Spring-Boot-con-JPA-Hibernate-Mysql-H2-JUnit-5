package com.example.AplicacionSpring.Service;

import com.example.AplicacionSpring.Model.Role;
import com.example.AplicacionSpring.Repository.IRoleJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    IRoleJpaRepository roleRepository;

    /**
     *Guarda el Role pasado por parametro en la BD
     */
    public Role guardarRole(Role role){
        return roleRepository.save(role);
    }

    /**
     *Devuelve un listado con todos los roles creados en la BD
     */
    public ArrayList<Role> obtenerRoles(){
        return (ArrayList<Role>)roleRepository.findAll();
    }

    /**
     *Si al invocar el metodo eliminarRole se envia un id valido, esté
     * recurre al repositorio para eliminar el role por id y returna un booleano
     * confirmando. Si de lo contrario no de pasa un id valido se retorna un
     * boolean negando el estado de eliminacion
     */
    public boolean eliminarRolePorId(Long id){
        try{
            roleRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    /**
     *Devuelve los datos del role asociado al Id pasado por
     * parametro
     */
    public Optional<Role> obtenerRolePorId(Long id){
        return roleRepository.findById(id);
    }

}
