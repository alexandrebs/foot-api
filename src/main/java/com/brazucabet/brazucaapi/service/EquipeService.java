package com.brazucabet.brazucaapi.service;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brazucabet.brazucaapi.dto.EquipeDTO;
import com.brazucabet.brazucaapi.dto.EquipeResponseDTO;
import com.brazucabet.brazucaapi.entity.Equipe;
import com.brazucabet.brazucaapi.exception.BadRequestException;
import com.brazucabet.brazucaapi.exception.NotFoundException;
import com.brazucabet.brazucaapi.repository.EquipeRepository;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class EquipeService {

	@Autowired
	private EquipeRepository equipeRepository; 
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Equipe buscarEquipeId(Long id) {

		return equipeRepository.findById(id).orElseThrow(
				() -> new NotFoundException("Nenhuma equipe encontrada com o id informado: "+ id));
	}

	
	public Equipe buscarEquipePorNome(String nomeEquipe) {

		return equipeRepository.findByNomeEquipe(nomeEquipe).orElseThrow(
				() -> new NotFoundException("Nenhuma equipe encontrada com o nome informado: "+ nomeEquipe));
	}
	
	public EquipeResponseDTO ListarEquipes() {
	
		EquipeResponseDTO equipeList = new EquipeResponseDTO();
		
		 equipeList.setEquipes(equipeRepository.findAll());
		 
		 return equipeList;
	}

	public Equipe inserirEquipe(EquipeDTO dto) {
		
		
		
		boolean exists = equipeRepository.existsByNomeEquipe(dto.getNomeEquipe());
		
		if(exists) {
			throw new BadRequestException("Já existe uma equipe cadastrada com o nome informado!");
		}
		
		Equipe equipe = modelMapper.map(dto, Equipe.class);
		return equipeRepository.save(equipe);
	}

	public void alterarEquipe(Long id,  EquipeDTO equipeDto) {

		
		boolean exists = equipeRepository.existsById(id);
		if(!exists) {
			
			throw new BadRequestException("Não foi possível alterar a equipe: ID Inexistente");
			
		}
		
		Equipe equipe = modelMapper.map(equipeDto, Equipe.class);
		
		equipe.setId(id);
		equipeRepository.save(equipe);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
