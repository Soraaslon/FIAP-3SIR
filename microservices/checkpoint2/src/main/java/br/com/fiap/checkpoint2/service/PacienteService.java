package br.com.fiap.checkpoint2.service;

import br.com.fiap.checkpoint2.dto.PacienteCreateDTO;
import br.com.fiap.checkpoint2.dto.PacienteDTO;
import br.com.fiap.checkpoint2.model.Paciente;
import br.com.fiap.checkpoint2.repository.PacienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public List<PacienteDTO> listarTodos() {
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    public PacienteDTO buscarPorId(Long id) {
        Paciente paciente = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return toDTO(paciente);
    }

    public PacienteDTO criar(PacienteCreateDTO dto) {
        Paciente paciente = new Paciente();
        BeanUtils.copyProperties(dto, paciente);
        repository.save(paciente);
        return toDTO(paciente);
    }

    public PacienteDTO atualizar(Long id, PacienteCreateDTO dto) {
        Paciente paciente = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        BeanUtils.copyProperties(dto, paciente, "id");
        repository.save(paciente);
        return toDTO(paciente);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        repository.deleteById(id);
    }

    private PacienteDTO toDTO(Paciente paciente) {
        PacienteDTO dto = new PacienteDTO();
        BeanUtils.copyProperties(paciente, dto);
        return dto;
    }
}
