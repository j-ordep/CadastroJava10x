package com.jordep.CadastroDeNinja.Missoes;

import com.jordep.CadastroDeNinja.Ninjas.NinjaDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public MissoesDTO criarMissao(MissoesDTO missoesDTO) {
        MissoesModel missoesModel = missoesMapper.map(missoesDTO);
        MissoesModel missoesRepo = missoesRepository.save(missoesModel);
        return missoesMapper.map(missoesRepo);
    }

    public List<MissoesDTO> listarMissoes() {
        List<MissoesModel> missoesModels = missoesRepository.findAll();
        return missoesModels.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    public MissoesDTO listarMissaoPorId(Long id) {
        Optional<MissoesModel> missoesModel =  missoesRepository.findById(id);
        return missoesModel.map(missoesMapper::map).orElse(null);
    }

    public MissoesDTO alterarMissao(Long id, MissoesDTO missaoDTO) {
        Optional<MissoesModel> missaoAtual = missoesRepository.findById(id);
        if (missaoAtual.isPresent()) {
            MissoesModel missaoModel = missoesMapper.map(missaoDTO);
            missaoModel.setId(id);
            MissoesModel missaoAtualizada = missoesRepository.save(missaoModel);
            return missoesMapper.map(missaoAtualizada);
        }
        return null;
    }

    public void deletarMissao(long id) {
        missoesRepository.deleteById(id);
    }

}
