package com.example.AplicacionSpring.Repository;

import com.example.AplicacionSpring.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeJpaRepsitory extends JpaRepository<Employee,Long> { //<tipo de Table, tipo id llave primaria>

    /**
     * Selecciona los campos de empleyee donde employeeid = '[param]'
     * Hibernate implementa la interfaz
     */
    Employee findByEmployeeid(String employeeid);

}
