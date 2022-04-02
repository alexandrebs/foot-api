package com.brazucabet.brazucaapi.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.brazucabet.brazucaapi.dto.EquipeDTO;
import com.brazucabet.brazucaapi.dto.EquipeResponseDTO;
import com.brazucabet.brazucaapi.entity.Equipe;
import com.brazucabet.brazucaapi.exception.StandardError;
import com.brazucabet.brazucaapi.exception.UnathorizedException;
import com.brazucabet.brazucaapi.service.EquipeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("API de equipes")
@RestController
@RequestMapping("/api/v1/equipes")
public class EquipeController {

	@Autowired
	private EquipeService equipeService;
	
	@ApiOperation(value = "Buscar equipe por ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok", response = Equipe.class),
			@ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unautorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = StandardError.class)
				
	})
	@GetMapping("/{id}")
	public ResponseEntity<Equipe> buscarEquipeId(@PathVariable("id") Long id){
		return ResponseEntity.ok().body(equipeService.buscarEquipeId(id));
	}
	

	@ApiOperation(value = "Listar equipes")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok", response = EquipeResponseDTO.class),
			@ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unautorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = StandardError.class)
				
	})
	@GetMapping
	public ResponseEntity<EquipeResponseDTO> listarEquipes(){
		return ResponseEntity.ok().body(equipeService.ListarEquipes());
	}
	
	
	
	@ApiOperation(value = "Inserir Equipe")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Created", response = Equipe.class),
			@ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unautorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = StandardError.class)
				
	})
	@PostMapping
	public ResponseEntity<Equipe> InserirEquipe(@Valid @RequestBody EquipeDTO dto){
		
		Equipe equipe = equipeService.inserirEquipe(dto);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
												  .path("/{id}")
												  .buildAndExpand(equipe.getId())
												  .toUri();
		
		return ResponseEntity.created(location).body(equipe);
	}
	
	
	
	@ApiOperation(value = "Alterar Equipe")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "no content", response = void.class),
			@ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unautorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = StandardError.class)
				
	})
	@PutMapping("/{id}")
	public ResponseEntity<Void> alterarEquipe(@PathVariable("id") Long id, @Valid @RequestBody EquipeDTO equipeDto ){
		
		equipeService.alterarEquipe(id, equipeDto);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
