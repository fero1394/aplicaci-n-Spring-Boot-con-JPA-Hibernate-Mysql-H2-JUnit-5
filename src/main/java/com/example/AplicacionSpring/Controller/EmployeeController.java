package com.example.AplicacionSpring.Controller;

import com.example.AplicacionSpring.Model.Employee;
import com.example.AplicacionSpring.Model.Role;
import com.example.AplicacionSpring.Service.EmployeeService;
import com.example.AplicacionSpring.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    /**
     * Obtener todos
     */
    @GetMapping()
    public ArrayList<Employee> obtenerEmployee() {
        return employeeService.obtenerEmployee();
    }


    /**
     * guardar empleado
     */
    @PostMapping()
    public Employee guardarEmployee(@RequestBody Employee employee) {
        return this.employeeService.guardarEmployee(employee);
    }

    /**
     * Obtener por id
     */
    @GetMapping(path = "/{id}")
    public Optional<Employee> obtenerRolePorId(@PathVariable("id") Long id) {
        return this.employeeService.obtenerEmployeePorId(id);
    }

    /**
     * Eliminar empleado
     */
    @DeleteMapping(path = "/{id}")
    public String eliminarEmpleadoPorId(@PathVariable("id") Long id) {
        boolean ok = this.employeeService.eliminarEmployeePorId(id);
        if (ok) {
            return "Se elimino el Empleado por id " + id;
        } else {
            return "No se pudo  eliminar el Empleado con id " + id;
        }
    }
}
