package com.jordep.CadastroDeNinja.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping ("/criar")
    public MissoesDTO criarMissoes(@RequestBody MissoesDTO missoesDTO) {
        return missoesService.criarMissao(missoesDTO);
    }

    @GetMapping("/listar")
    public List<MissoesDTO> listarMissoes() {
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesDTO listarPorId(@PathVariable Long id) {
        return missoesService.listarMissaoPorId(id);
    }

    @PutMapping("/alterar/{id}")
    public String alterarMissao(@PathVariable Long id, @RequestBody MissoesModel missoesModel) {
        return "missao alterada";
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id) {
        missoesService.deletarMissao(id);
    }

}
