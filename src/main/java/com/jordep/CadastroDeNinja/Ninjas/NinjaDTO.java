package com.jordep.CadastroDeNinja.Ninjas;


import com.jordep.CadastroDeNinja.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private long id;
    private String nome;
    private String imgUrl;
    private String email;
    private int idade;
    private MissoesModel missoes;
    private String rank;

}
