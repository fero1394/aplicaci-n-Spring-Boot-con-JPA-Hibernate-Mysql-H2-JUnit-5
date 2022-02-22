package com.example.AplicacionSpring.Repository;

import com.example.AplicacionSpring.Model.Employee;
import com.example.AplicacionSpring.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeJpaRepsitory extends JpaRepository<Employee,Long> { //<tipo de Table, tipo id llave primaria>

    /**
     * Selecciona los campos de empleyee donde employeeid = '[param]'
     * Hibernate implementa la interfaz
     */
    Employee findByEmployeeid(String employeeid);
    List<Employee> findByLastName(String lastName);
    List<Role> findByRole(Integer roleModel);
}
