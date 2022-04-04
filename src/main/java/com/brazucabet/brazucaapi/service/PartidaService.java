package com.brazucabet.brazucaapi.service;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brazucabet.brazucaapi.dto.PartidaDTO;
import com.brazucabet.brazucaapi.dto.PartidaGoogleDTO;
import com.brazucabet.brazucaapi.dto.PartidaResponseDTO;
import com.brazucabet.brazucaapi.entity.Equipe;
import com.brazucabet.brazucaapi.entity.Partida;
import com.brazucabet.brazucaapi.exception.NotFoundException;
import com.brazucabet.brazucaapi.repository.PartidaRepository;

@Service
public class PartidaService {

	@Autowired
	PartidaRepository partidaRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EquipeService equipeServive;
	
	public Partida buscarPartidaId(Long id) {

		return partidaRepository.findById(id).orElseThrow(
				() -> new NotFoundException("Nenhuma equipe encontrada com o id informado: "+ id));
	}

	public PartidaResponseDTO ListarPartidas() {

		PartidaResponseDTO partidas = new PartidaResponseDTO();
		
		 partidas.setPartidas(partidaRepository.findAll());
		
		return partidas;
	}

	public Partida inserirPartida(PartidaDTO dto) {

		Partida partida = modelMapper.map(dto, Partida.class);
		
		partida.setEquipeCasa(equipeServive.buscarEquipePorNome(dto.getNomeEquipeCasa()));
		partida.setEquipeVisitante(equipeServive.buscarEquipePorNome(dto.getNomeEquipeVisitante()));
		
		return salvarPartida(partida);
	}
	
	private Partida salvarPartida(Partida partida) {
		
		return partidaRepository.save(partida);
	}

	public void alterarPartida(Long id, PartidaDTO dto) {
		
		boolean exists = partidaRepository.existsById(id);
		
		if(!exists) {
			throw new NotFoundException("Não foi possível autalizar a partida: ID inexistente!");
		}
		
		Partida partida = buscarPartidaId(id);
		
		partida.setEquipeCasa(equipeServive.buscarEquipePorNome(dto.getNomeEquipeCasa()));
		partida.setEquipeVisitante(equipeServive.buscarEquipePorNome(dto.getNomeEquipeVisitante()));
		partida.setDatahoraPartida(dto.getDataHoraPartida());
		partida.setLocalPartida(dto.getLocalPartida());
		
		 salvarPartida(partida);
		
	}

	public void atualizaPartida(Partida partida, PartidaGoogleDTO partidaGoogle) {
		partida.setPlacarEquipeCasa(partidaGoogle.getPlacarEquipeCasa());
		partida.setPlacarEquipeVisitante(partidaGoogle.getPlacarEquipeVisitante());
		partida.setGolsEquipeCasa(partidaGoogle.getGolsEquipeCasa());
		partida.setGolsEquipeVisitante(partidaGoogle.getGolsEquipeVisitante());
		partida.setPlacarEstendidoEquipeCasa(partidaGoogle.getPlacarEstendidoEquipeCasa());
		partida.setPlacarEstendidoEquipeVisitante(partidaGoogle.getPlacarEstendidoEquipeVisitante());
		partida.setTempoPartida(partidaGoogle.getTempoPartida());
		
		salvarPartida(partida);
	}

	public List<Partida> listarPartidasPeriodo() {
		return partidaRepository.listarPartidasPeriodo();
	}

	public Integer buscarQuantidadePartidasPeriodo() {
		return partidaRepository.buscarQuantidadePartidasPeriodo();
	}


	
	
	
}
