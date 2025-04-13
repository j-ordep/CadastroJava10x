package com.jordep.CadastroDeNinja.Ninjas;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.support.ResourceTransactionManager;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService, ResourceTransactionManager resourceTransactionManager) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso " + novoNinja.getNome() + " ID: " + novoNinja.getId());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> listaDeNinjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(listaDeNinjas);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjaPorId(@PathVariable Long id) {
        NinjaDTO ninjaEncontrado = ninjaService.listarNinjarPorId(id);
        if (ninjaEncontrado != null) {
            return ResponseEntity.ok()
                    .body("Ninja: " + ninjaEncontrado.getNome() + " ID: " + ninjaEncontrado.getId());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja com id: " + id + " não encontrado");
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja){
        NinjaDTO ninjaDTO = ninjaService.alterarNinja(id, ninja);
        if (ninjaDTO != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja com id: " + id + " não existe nos nossos registros");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable long id) {
        if (ninjaService.listarNinjarPorId(id) != null){
            ninjaService.deletarPorId(id);
            return ResponseEntity.ok("Ninja com id: " + id + " deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com id: " + id + "não encontrado");
        }
    }

}