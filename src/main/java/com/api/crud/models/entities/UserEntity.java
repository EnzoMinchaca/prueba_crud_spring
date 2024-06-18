package com.api.crud.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column //si no especificamos un name, se pasa como first_name autom xq no acepta camelcase
    @NotBlank
    @Size(max = 80)
    private String firstName;

    @Column
    @NotBlank
    @Size(max = 80)
    private String lastName;

    @Column
    @Email
    private String email;

    @Column
    @NotBlank
    private String password;

    //fetchtype.eager con esto me traigo todos los roles asociados al usuario de una vez, con lazy me trae uno por uno cuando lo solicite y no qiero esto
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = RoleEntity.class, cascade = CascadeType.PERSIST)   //roleEntity: le indico com cual clase se establece la relacion, cascade: si se elimina el usuario hace que no se borren los roles, osea que la cascada o creacion de esto va a ser solo cuando se persista o cree un usuario, si se borra uno no pasa nada
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))  //relacion MxN genera tabla nueva, con el name decimos como se llamara, con joinColums le digo como se llamaran las fk primero de la tabla donde estoy y despues de la que esta relacionada, asi se escribe cuando es MxN
    private Set<RoleEntity> roles = new HashSet<>();  //ser xq no permite tener elementos duplicados, con list si pasa eso

    public UserEntity(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
