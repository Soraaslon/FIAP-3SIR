package br.com.fiap.checkpoint2.controle;

import br.com.fiap.checkpoint2.dto.ConsultaCreateDTO;
import br.com.fiap.checkpoint2.dto.ConsultaDTO;
import br.com.fiap.checkpoint2.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<ConsultaDTO> criar(@RequestBody ConsultaCreateDTO dto) {
        ConsultaDTO consultaDTO = consultaService.criar(dto);
        return new ResponseEntity<>(consultaDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public List<ConsultaDTO> listarTodos() {
        return consultaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ConsultaDTO buscarPorId(@PathVariable Long id) {
        return consultaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ConsultaDTO atualizar(@PathVariable Long id, @RequestBody ConsultaCreateDTO dto) {
        return consultaService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        consultaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
