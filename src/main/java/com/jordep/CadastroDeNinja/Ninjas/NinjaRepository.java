package com.jordep.CadastroDeNinja.Ninjas;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {

    NinjaModel findByNome(String nome);

}
