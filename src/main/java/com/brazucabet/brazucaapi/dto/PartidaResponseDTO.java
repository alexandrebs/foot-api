package com.brazucabet.brazucaapi.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.brazucabet.brazucaapi.entity.Equipe;
import com.brazucabet.brazucaapi.entity.Partida;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartidaResponseDTO implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	
	private List<Partida> partidas;
}
