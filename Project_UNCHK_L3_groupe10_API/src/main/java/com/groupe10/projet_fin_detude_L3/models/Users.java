package com.groupe10.projet_fin_detude_L3.models;

import com.groupe10.projet_fin_detude_L3.models.enums.Roles;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    @Column
    private String prenom;
    @Column
    private String nom;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String telephone;
    @Column
    private String adresse;
    @Column
    @Enumerated(EnumType.STRING)
    private Roles role;
    @Column
    private boolean enabled = true;


}
