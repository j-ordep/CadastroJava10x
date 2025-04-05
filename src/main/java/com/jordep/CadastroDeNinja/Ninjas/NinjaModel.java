package com.jordep.CadastroDeNinja.Ninjas;


import com.jordep.CadastroDeNinja.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tb_cadastro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(unique = true)
    private String email;

    @Column(name = "idade")
    private int idade;


    // muitos ninjas para uma missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") // fk
    private MissoesModel missoes;

    @Column(name = "rank")
    private String rank;

}