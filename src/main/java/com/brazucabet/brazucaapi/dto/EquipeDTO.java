package com.brazucabet.brazucaapi.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EquipeDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@NotBlank
	private String nomeEquipe;
	
	@NotBlank
	private String urlLogoEquipe;
	
/*	
	@NotNull
	@ApiModelProperty(example="dd/mm/yyyy HH:mm")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "America/Sao_Paulo")
	private Date dataHoraPartida; 
	*/
}
