package com.brazucabet.brazucaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.brazucabet.brazucaapi.entity.Partida;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long> {

	@Query(name = "buscar_quantidade_partidas_periodo",
			value = "select count(*) from tb_par_partida as p "
					+ "where p.par_data_hora_partida between dateadd(hour, -3, current_timestamp) and current_timestamp "
					+ "and ifnull(p.par_tempo_partida, 'Vazio') != 'Encerrado' ",
			nativeQuery = true)
	public Integer buscarQuantidadePartidasPeriodo();

	@Query(name = "buscar_quantidade_partidas_periodo",
			value = "select * from tb_par_partida as p "
					+ "where p.par_data_hora_partida between dateadd(hour, -3, current_timestamp) and current_timestamp "
					+ "and ifnull(p.par_tempo_partida, 'Vazio') != 'Encerrado' ",
			nativeQuery = true)
	public List<Partida> listarPartidasPeriodo();
}
