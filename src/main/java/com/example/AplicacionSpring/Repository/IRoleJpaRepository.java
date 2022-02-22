package com.example.AplicacionSpring.Repository;

import com.example.AplicacionSpring.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleJpaRepository extends JpaRepository<Role,Long> {


}
