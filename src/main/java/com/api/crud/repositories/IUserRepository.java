package com.api.crud.repositories;

import com.api.crud.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //con esto indicamos que es una clase que permite hacer consultas a una base de datos
public interface IUserRepository extends JpaRepository<UserModel, Long> {   //<modelo al cual realizaremos consultas, tipo de dato del id>

}
