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
import com.brazucabet.brazucaapi.dto.PartidaDTO;
import com.brazucabet.brazucaapi.dto.PartidaResponseDTO;
import com.brazucabet.brazucaapi.entity.Equipe;
import com.brazucabet.brazucaapi.entity.Partida;
import com.brazucabet.brazucaapi.exception.StandardError;
import com.brazucabet.brazucaapi.service.PartidaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("API de Partidas")
@RestController
@RequestMapping("/api/v1/partidas")
public class PartidaController {

	@Autowired
	private PartidaService partidaService;
	
	
	@ApiOperation(value = "Buscar partida por ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok", response = Partida.class),
			@ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unautorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = StandardError.class)
				
	})
	@GetMapping("/{id}")
	public ResponseEntity<Partida> buscarPartidaId(@PathVariable("id") Long id){
		return ResponseEntity.ok().body(partidaService.buscarPartidaId(id));
	}
	
	
	@ApiOperation(value = "Listar partidas")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok", response = PartidaResponseDTO.class),
			@ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unautorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = StandardError.class)
				
	})
	@GetMapping
	public ResponseEntity<PartidaResponseDTO> listarPartidas(){
		return ResponseEntity.ok().body(partidaService.ListarPartidas());
	}
	
	
	
	@ApiOperation(value = "Inserir Partida")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Created", response = Partida.class),
			@ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unautorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = StandardError.class)
				
	})
	@PostMapping
	public ResponseEntity<Partida> InserirPartida(@Valid @RequestBody PartidaDTO dto){
		
		Partida partida = partidaService.inserirPartida(dto);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
												  .path("/{id}")
												  .buildAndExpand(partida.getId())
												  .toUri();
		
		return ResponseEntity.created(location).body(partida);
	}
	
	
	@ApiOperation(value = "Alterar Partida")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "no content", response = Void.class),
			@ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unautorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = StandardError.class)
				
	})
	@PutMapping("/{id}")
	public ResponseEntity<Void> alterarPartida(@PathVariable("id") Long id, @Valid @RequestBody PartidaDTO dto ){
		
		partidaService.alterarPartida(id, dto);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
	
}
