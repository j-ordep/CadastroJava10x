package com.jordep.CadastroDeNinja.Ninjas;


import com.jordep.CadastroDeNinja.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "tb_cadastro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private String idade;

    // muitos ninjas para uma missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") // fk
    private MissoesModel missoes;
}