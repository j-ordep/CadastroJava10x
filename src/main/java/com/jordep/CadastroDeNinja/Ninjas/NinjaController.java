package com.jordep.CadastroDeNinja.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    final private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/criar")
    @Operation(summary = "Sumaary: cria um novo ninjas", description = "Descrição: essa rota cria um novo ninja e adiciona no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "erro na criação do ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso " + novoNinja.getNome() + " ID: " + novoNinja.getId());
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar todos os ninjas", description = "lista todos os ninjas cadastrados no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "listagem de ninjas feita com sucesso"),
            @ApiResponse(responseCode = "400", description = "erro na listagem dos ninjas")
    })
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> listaDeNinjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(listaDeNinjas);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Listar ninja por ID", description = "busca por ID o ninja no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ninja encontrado no banco de dados"),
            @ApiResponse(responseCode = "404", description = "ID do ninja não encontrado no banco de dados")
    })
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
    @Operation(summary = "Alterar ninja por ID", description = "altera o ninja é pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "ID do ninja não encontrado no banco de dados")
    })
    public ResponseEntity<?> alterarNinja(
            @Parameter(description = "Usuário manda o id do atual ninja no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados do novo ninja no body da req")
            @RequestBody NinjaDTO ninja
    ){
        NinjaDTO ninjaDTO = ninjaService.alterarNinja(id, ninja);
        if (ninjaDTO != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja com id: " + id + " não existe nos nossos registros");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable Long id) {
        if (ninjaService.listarNinjarPorId(id) != null){
            ninjaService.deletarPorId(id);
            return ResponseEntity.ok("Ninja com id: " + id + " deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com id: " + id + "não encontrado");
        }
    }

}