package com.jordep.CadastroDeNinja.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // Adiconar ninja - (CREATE)
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja Criado";
    }

    // Mostrar todos os Ninjas - (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    // Procurar Ninja por ID - (READ)
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjaPorId(@PathVariable Long id) {
        return ninjaService.listarNinjarPorId(id);
    }



    // Alterar dados do Ninja - (UPDATE)
    @PutMapping("/alterarNinja")
    public String alterarNinja(){
        return "atualizando ninja";
    }

    // Deletar Ninja - (DELETE)
    @DeleteMapping("/deletarNinja")
    public String deletarNinja() {
        return "deletado";
    }

}
