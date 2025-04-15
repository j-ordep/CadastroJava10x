package com.jordep.CadastroDeNinja.Missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    final private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping ("/criar")
    public ResponseEntity<?> criarMissoes(@RequestBody MissoesDTO missoesDTO) {
        MissoesDTO missao = missoesService.criarMissao(missoesDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criado com sucesso: " + missao.getNome() + " ID: " + missao.getId());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes() {
        List<MissoesDTO> listaDeMissoes = missoesService.listarMissoes();
        return ResponseEntity.ok(listaDeMissoes);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id) {
        MissoesDTO missoesDTO = missoesService.listarMissaoPorId(id);
        if (missoesDTO != null) {
            return ResponseEntity.ok().body("Achei");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado" + id);
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missoesModel) {
        MissoesDTO missoes = missoesService.alterarMissao(id, missoesModel);
        if (missoes != null) {
            return ResponseEntity.ok(missoes);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado " + id);
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id) {
        if (missoesService.listarMissaoPorId(id) != null) {
            missoesService.deletarMissao(id);
            return ResponseEntity.ok("Deletado id : " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não achamo esse id ae");
        }
    }

}
