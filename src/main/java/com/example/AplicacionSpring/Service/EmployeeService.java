package com.example.AplicacionSpring.Service;

import com.example.AplicacionSpring.Model.Employee;
import com.example.AplicacionSpring.Model.Role;
import com.example.AplicacionSpring.Repository.IEmployeeJpaRepsitory;
import com.example.AplicacionSpring.Repository.IRoleJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    IEmployeeJpaRepsitory employeeRepository;

    /**
     *Devuelve un listado con todos los empleado creados en la BD
     */
    public ArrayList<Employee> obtenerEmployee(){
        return (ArrayList<Employee>)employeeRepository.findAll();
    }

    /**
     *Guarda el empleado pasado por parametro en la BD
     */
    public Employee guardarEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    /**
     *Devuelve los datos del empleado asociado al Id pasado por
     * parametro
     */
    public Optional<Employee> obtenerEmployeePorId(Long id){
        return employeeRepository.findById(id);
    }

    public boolean eliminarEmployeePorId(Long id){
        try{
            employeeRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

}
