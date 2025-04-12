package com.jordep.CadastroDeNinja.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.criarNinja(ninja);
    }

    // Mostrar todos os Ninjas - (READ)
    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    // Procurar Ninja por ID - (READ)
    @GetMapping("/listar/{id}")
    public NinjaDTO listarNinjaPorId(@PathVariable Long id) {
        return ninjaService.listarNinjarPorId(id);
    }

    // Alterar TODOS dados do Ninja - (UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja){
        return ninjaService.alterarNinja(id, ninja);
    }

    // Deletar Ninja - (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinja(@PathVariable long id) {
        ninjaService.deletarPorId(id);
    }

}
