package com.brazucabet.brazucaapi.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartidaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String statusPartida;
	private String tempoPartida;

	// Informação da equipe da casa
	private String nomeEquipeCasa;
	private String urlLogEquipeCasa;
	private Integer placarCasa;
	private String golsEquipeCasa;
	private String placarEstendidoEquipeCasa;

	// Informação da equipe da visitante
	private String nomeEquipeVisitante;
	private String urlLogEquipeVisitante;
	private Integer placarVisitante;
	private String golsEquipeVisitante;
	private String placarEstendidoEquipeVisitante;

}
