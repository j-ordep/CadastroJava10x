package com.jordep.CadastroDeNinja.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<NinjaModel> listarNinjas() {
         return ninjaRepository.findAll();
    }

    public NinjaModel listarNinjarPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    public NinjaModel alterarNinja(Long id, NinjaModel ninjaAtualizado) {
        if (ninjaRepository.existsById(id)) {
            ninjaAtualizado.setId(id); // atualiza o id para esse novo obj, logo o antigo ninja que estava ai foi jogado fora
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }

    public void deletarPorId(Long id) {
        ninjaRepository.deleteById(id);
    }

}
