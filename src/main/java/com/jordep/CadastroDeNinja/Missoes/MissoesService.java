package com.jordep.CadastroDeNinja.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public MissoesModel criarMissao(MissoesModel missoesModel) {
        return missoesRepository.save(missoesModel);
    }

    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    public MissoesModel listarMissaoPorId(Long id) {
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.orElse(null);
    }

    public MissoesModel alterarMissao(Long id, MissoesModel missaoAtual) {
        if (missoesRepository.existsById(id)) {
            missaoAtual.setId(id);
            return missoesRepository.save(missaoAtual);
        }
        return null;
    }

    public void deletarMissao(long id) {
        missoesRepository.deleteById(id);
    }

}
