package com.brazucabet.brazucaapi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_par_partida")
public class Partida implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "par_id")
	private Long id;

	@Transient
	private String statusPartida;

	@ManyToOne
	@JoinColumn(name = "eq_equipe_casa_id")
	private Equipe equipeCasa;

	@ManyToOne
	@JoinColumn(name = "eq_equipe_visitante_id")
	private Equipe equipeVisitante;

	@Column(name = "par_placar_equipe_casa")
	private Integer placarEquipeCasa;

	@Column(name = "par_placar_equipe_visitante")
	private Integer placarEquipeVisitante;

	@Column(name = "par_gols_equipe_casa")
	private String golsEquipeCasa;

	@Column(name = "par_gols_equipe_visitante")
	private String golsEquipeVisitante;

	@Column(name = "par_placar_estendido_equipe_casa")
	private Integer placarEstendidoEquipeCasa;

	@Column(name = "par_placar_estendido_equipe_visitante")
	private Integer placarEstendidoEquipeVisitante;
	
	@ApiModelProperty(example = "dd/MM/yyyy HH:mm")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "America/Sao_Paulo")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "par_data_hora_partida")
	private Date datahoraPartida;
	
	@Column(name = "par_local_partida")
	private String localPartida;
	
	@Column(name="par_tempo_partida")
	private String tempoPartida;

}
