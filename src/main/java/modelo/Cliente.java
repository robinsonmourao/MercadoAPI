package modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class Cliente {

    private Long id;
    private String nome;
    private String CPF;

}
