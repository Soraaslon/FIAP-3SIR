package br.com.fiap.checkpoint2.service;

import br.com.fiap.checkpoint2.dto.ProfissionalCreateDTO;
import br.com.fiap.checkpoint2.dto.ProfissionalDTO;
import br.com.fiap.checkpoint2.model.Profissional;
import br.com.fiap.checkpoint2.repository.ProfissionalRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository repository;

    public List<ProfissionalDTO> listarTodos() {
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    public ProfissionalDTO buscarPorId(Long id) {
        Profissional profissional = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return toDTO(profissional);
    }

    public ProfissionalDTO criar(ProfissionalCreateDTO dto) {
        Profissional profissional = new Profissional();
        profissional.setNome(dto.getNome());
        profissional.setEspecialidade(dto.getEspecialidade());
        profissional.setValorHora(dto.getValorHora());
        repository.save(profissional);
        return toDTO(profissional);
    }

    public ProfissionalDTO atualizar(Long id, ProfissionalCreateDTO dto) {
        Profissional profissional = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        profissional.setNome(dto.getNome());
        profissional.setEspecialidade(dto.getEspecialidade());
        profissional.setValorHora(dto.getValorHora());
        repository.save(profissional);
        return toDTO(profissional);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        repository.deleteById(id);
    }

    private ProfissionalDTO toDTO(Profissional profissional) {
        ProfissionalDTO dto = new ProfissionalDTO();
        BeanUtils.copyProperties(profissional, dto);
        return dto;
    }
}
