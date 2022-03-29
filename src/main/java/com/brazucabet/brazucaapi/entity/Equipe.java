package com.brazucabet.brazucaapi.entity;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "tb_eq_equipe")
public class Equipe implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eq_id")
	private Long id;
	
	@Column(name = "eq_nome_equipe")
	private String nomeEquipe;
	
	@Column(name = "eq_url_logo_equipe")
	private String urlLogoEquipe;
	
	
	
}
