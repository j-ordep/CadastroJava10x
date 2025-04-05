package com.jordep.CadastroDeNinja.Missoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jordep.CadastroDeNinja.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "tb_missoes")

@AllArgsConstructor
@NoArgsConstructor
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dificuldade;

    // uma missão para muitos ninjas
    @JsonIgnore
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjaModels;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public List<NinjaModel> getNinjaModels() {
        return ninjaModels;
    }

    public void setNinjaModels(List<NinjaModel> ninjaModels) {
        this.ninjaModels = ninjaModels;
    }
}
