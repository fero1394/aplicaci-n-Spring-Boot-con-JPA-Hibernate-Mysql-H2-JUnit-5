package com.example.AplicacionSpring;

import com.example.AplicacionSpring.Model.Employee;
import com.example.AplicacionSpring.Model.Project;
import com.example.AplicacionSpring.Model.Role;
import com.example.AplicacionSpring.Repository.IEmployeeJpaRepsitory;
import com.example.AplicacionSpring.Repository.IProjectJpaRepsitory;
import com.example.AplicacionSpring.Repository.IRoleJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest //con esto le digo que solo quiero enfocarme en el JPA
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EmployeeJpaRepsitoryTest {

    @Autowired //autowire me inyecta o me crea una implementacion del repositorio
    private IEmployeeJpaRepsitory repo;

    @Autowired
    private IEmployeeJpaRepsitory repoEmpl;

    @Autowired
    private IRoleJpaRepository repoRole;

    @Autowired
    private IProjectJpaRepsitory repoProj;

    @Test
    public void saveEmployee(){

        Role admin = new Role("ROLE_ADMIN");
        Role dev = new Role("ROLE_DEV");

        admin = repoRole.save(admin);
        dev = repoRole.save(dev);

        Project proj1 = new Project("proj1");
        Project proj2 = new Project("proj2");
        Project proj3 = new Project("proj3");

        proj1 = repoProj.save(proj1);
        proj2 = repoProj.save(proj2);
        proj3 = repoProj.save(proj3);

        Employee john = new Employee("John","Smith","empl123",dev);
        Employee claire = new Employee("Claire","Simpson","empl124",admin);

        john.getProjects().add(proj1);
        john.getProjects().add(proj2);

        claire.getProjects().add(proj1);
        claire.getProjects().add(proj2);
        claire.getProjects().add(proj3);

        repoEmpl.save(john);
        repoEmpl.save(claire);

        repoEmpl.flush(); //para insertarlos de inmediato

        Employee empl124 = repoEmpl.findByEmployeeid("empl124");
        assertEquals("Claire",empl124.getFirstName());
        assertEquals(2,repoEmpl.findAll().size());
        assertEquals(admin,empl124.getRole());

        //ya este es el test
        //assertEquals(2,repo.findAll().size()); //voy a recuperar los registros que he insertado y los voy a recuperar si todoo esta bien debo tener dos registros

    }
}
