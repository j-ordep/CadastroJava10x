package com.jordep.CadastroDeNinja.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_ninja")
public class Ninja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cla;
    private String tecnica;

    public Ninja() {
    }

    public Ninja(String nome, String cla, String tecnica) {
        this.nome = nome;
        this.cla = cla;
        this.tecnica = tecnica;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {
        this.cla = cla;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }
}

//teste