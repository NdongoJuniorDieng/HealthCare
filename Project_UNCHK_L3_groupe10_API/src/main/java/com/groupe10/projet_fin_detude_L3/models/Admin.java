package com.groupe10.projet_fin_detude_L3.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends Users{
    @Column
    private String hospitalName;

}
