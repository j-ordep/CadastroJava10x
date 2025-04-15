package com.jordep.CadastroDeNinja.Ninjas;

import com.jordep.CadastroDeNinja.Missoes.MissoesMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
       NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
       ninjaModel = ninjaRepository.save(ninjaModel);
       return ninjaMapper.map(ninjaModel);
    }

    public List<NinjaDTO> listarNinjas() {
         List<NinjaModel> ninjaModels = ninjaRepository.findAll();
        return ninjaModels.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    public NinjaDTO listarNinjarPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
    }

    public NinjaDTO alterarNinja(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaAtual = ninjaRepository.findById(id);
        if (ninjaAtual.isPresent()) {
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }

    public void deletarPorId(Long id) {
        ninjaRepository.deleteById(id);
    }

}
