package com.github.soraaslon.study_apir;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ControllerProduto {

	@PostMapping
	public ResponseEntity<String> criarProduto() {
		return ResponseEntity.status(HttpStatus.CREATED).body("Produto criado");
	}
		
	
	@PutMapping
	public String atualizarProduto() {
		return "Produto atualizado";
	}
	
	@DeleteMapping
	public String deletarProduto() {
		return "Produto deletado";
	}
	
	
}
