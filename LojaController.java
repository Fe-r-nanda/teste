package br.org.fe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.fe.LojaModel;
import br.org.fe.repository.LojaRepository;

@RestController
@RequestMapping("/produtos")
public class LojaController {
	
	@Autowired
	private LojaRepository lojaRepository;
	
	@GetMapping
	private ResponseEntity<List<LojaModel>> getAll(){
		return ResponseEntity.ok(lojaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<LojaModel> getById(@PathVariable long id){
		return lojaRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("produto/{produto}")
	public ResponseEntity<List<LojaModel>> getByNome(@PathVariable String produto){
		return ResponseEntity.ok(lojaRepository.findAllByProdutoContainingIgnoreCase(produto));
	}
	
	@PostMapping 
	public ResponseEntity<LojaModel> post (@RequestBody LojaModel lojaModel){
	return ResponseEntity.status(HttpStatus.CREATED).body(lojaRepository.save(lojaModel));
}
	
	@PutMapping 
	public ResponseEntity<LojaModel> put (@RequestBody LojaModel lojaModel){
		return ResponseEntity.status(HttpStatus.OK).body(lojaRepository.save(lojaModel));
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable long id) {
		lojaRepository.deleteById(id);
	}

}
