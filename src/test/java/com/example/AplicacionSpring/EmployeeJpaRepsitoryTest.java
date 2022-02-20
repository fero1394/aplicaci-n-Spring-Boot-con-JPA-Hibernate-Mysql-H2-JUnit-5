package com.example.AplicacionSpring;

import com.example.AplicacionSpring.Model.Employee;
import com.example.AplicacionSpring.Repository.IEmployeeJpaRepsitory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest //con esto le digo que solo quiero enfocarme en el JPA
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeJpaRepsitoryTest {

    @Autowired //autowire me inyecta o me crea una implementacion del repositorio
    private IEmployeeJpaRepsitory repo;

    @Test
    public void saveEmployee(){
        Employee john = new Employee("John","Smith","empl123");
        Employee claire = new Employee("Claire","Simpson","empl124");

        repo.save(john);
        repo.save(claire);

        repo.flush(); //para insertarlos de inmediato

        //ya este es el test
        assertEquals(2,repo.findAll().size()); //voy a recuperar los registros que he insertado y los voy a recuperar si todoo esta bien debo tener dos registros
    }
}
