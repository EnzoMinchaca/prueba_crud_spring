package com.api.crud.repositories;

import com.api.crud.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //con esto indicamos que es una clase que permite hacer consultas a una base de datos
public interface IUserRepository extends JpaRepository<UserEntity, Long> {   //<modelo al cual realizaremos consultas, tipo de dato del id>

    //creamos una query para buscar por email, con : le aclaramos cual sera el valor, por eso tiene que ser igual al nombre del parametro, nativeQuery para indicar que es una query
    //@Query(value = "SELECT * FROM user WHERE email = :email", nativeQuery = true)
    Optional<UserEntity> findByEmail(String email);

    boolean existsByEmail(String email);

    //@Query("SELECT u FROM UserEntity WHERE u.first_name = ?1")
    //Optional<UserEntity> findByFirstName(String first_name);

}
