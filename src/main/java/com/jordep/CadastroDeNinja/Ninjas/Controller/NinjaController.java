package com.jordep.CadastroDeNinja.Ninjas.Controller;

import com.jordep.CadastroDeNinja.Ninjas.Model.NinjaModel;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
public class NinjaController {

    // Adiconar ninja - (CREATE)
    @PostMapping("/criarNinja")
    public String criarNinja() {
        return "Ninja Criado";
    }

    // Mostrar todos os Ninjas - (READ)
    @GetMapping("/todos")
    public String mostrarTodosOsNinja() {
        return "todos os ninjas";
    }


    // Procurar Ninja por ID - (CREATE)
    @GetMapping("/todosId")
    public String mostrarNinja() {
        return "Mostrando ninja por id";
    }

    // Alterar dados do Ninja - (UPDATE)
    @PutMapping("/alterar")
    public String alterarNinja(@PathVariable Long ninjaId){
        return "atualizando ninja";
    }

    // Deletar Ninja - (DELETE)
    @DeleteMapping("/deletar")
    public String deletarNinja() {
        return "deletado";
    }

}
