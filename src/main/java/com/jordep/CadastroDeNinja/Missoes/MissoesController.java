package com.jordep.CadastroDeNinja.Missoes;

import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
public class MissoesController {

    @GetMapping("/listar")
    public String listarMissaos() {
        return "missao listada";
    }

    @PostMapping ("/criar")
    public String criarMissoes() {
        return "missao criada";
    }

    @PutMapping("/alterar")
    public String alterarMissao() {
        return "missao alterada";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return "missao deletada";
    }

}
