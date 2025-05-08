package br.com.fiap.checkpoint2.service;

import br.com.fiap.checkpoint2.dto.ConsultaCreateDTO;
import br.com.fiap.checkpoint2.dto.ConsultaDTO;
import br.com.fiap.checkpoint2.model.Consulta;
import br.com.fiap.checkpoint2.repository.ConsultaRepository;
import br.com.fiap.checkpoint2.repository.PacienteRepository;
import br.com.fiap.checkpoint2.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<ConsultaDTO> listarTodos() {
        return consultaRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ConsultaDTO buscarPorId(Long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Consulta não encontrada"));
        return toDTO(consulta);
    }

    public ConsultaDTO criar(ConsultaCreateDTO dto) {
        Consulta consulta = new Consulta();
        // associações obrigatórias
        consulta.setProfissional(
                profissionalRepository.findById(dto.getProfissionalId())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Profissional não encontrado"))
        );
        consulta.setPaciente(
                pacienteRepository.findById(dto.getPacienteId())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado"))
        );

        consulta.setDataConsulta(dto.getDataConsulta());
        consulta.setStatusConsulta(dto.getStatusConsulta());
        consulta.setQuantidadeHoras(dto.getQuantidadeHoras());
        consulta.setValorConsulta(dto.getValorConsulta());

        consultaRepository.save(consulta);
        return toDTO(consulta);
    }

    public ConsultaDTO atualizar(Long id, ConsultaCreateDTO dto) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Consulta não encontrada"));

        // Atualiza atributos
        consulta.setDataConsulta(dto.getDataConsulta());
        consulta.setStatusConsulta(dto.getStatusConsulta());
        consulta.setQuantidadeHoras(dto.getQuantidadeHoras());
        consulta.setValorConsulta(dto.getValorConsulta());

        // Se desejar atualizar os relacionamentos, pode ser feito:
        if (dto.getProfissionalId() != null) {
            consulta.setProfissional(
                    profissionalRepository.findById(dto.getProfissionalId())
                            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profissional não encontrado"))
            );
        }
        if (dto.getPacienteId() != null) {
            consulta.setPaciente(
                    pacienteRepository.findById(dto.getPacienteId())
                            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado"))
            );
        }

        consultaRepository.save(consulta);
        return toDTO(consulta);
    }

    public void deletar(Long id) {
        if (!consultaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Consulta não encontrada");
        }
        consultaRepository.deleteById(id);
    }

    // Método para converter Consulta em ConsultaDTO
    private ConsultaDTO toDTO(Consulta consulta) {
        ConsultaDTO dto = new ConsultaDTO();
        dto.setId(consulta.getId());
        dto.setProfissionalId(consulta.getProfissional().getId());
        dto.setPacienteId(consulta.getPaciente().getId());
        dto.setDataConsulta(consulta.getDataConsulta());
        dto.setStatusConsulta(consulta.getStatusConsulta());
        dto.setQuantidadeHoras(consulta.getQuantidadeHoras());
        dto.setValorConsulta(consulta.getValorConsulta());
        dto.setCreatedAt(consulta.getCreatedAt());
        dto.setUpdatedAt(consulta.getUpdatedAt());
        return dto;
    }
}
