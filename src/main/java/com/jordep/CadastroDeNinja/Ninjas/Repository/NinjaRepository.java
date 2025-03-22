package com.jordep.CadastroDeNinja.Ninjas.Repository;

import com.jordep.CadastroDeNinja.Ninjas.Model.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {



}
