package br.com.fiap.checkpoint2.controle;

import br.com.fiap.checkpoint2.dto.ProfissionalCreateDTO;
import br.com.fiap.checkpoint2.dto.ProfissionalDTO;
import br.com.fiap.checkpoint2.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalService service;

    @PostMapping
    public ResponseEntity<ProfissionalDTO> criar(@RequestBody ProfissionalCreateDTO dto) {
        return new ResponseEntity<>(service.criar(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<ProfissionalDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ProfissionalDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ProfissionalDTO atualizar(@PathVariable Long id, @RequestBody ProfissionalCreateDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
