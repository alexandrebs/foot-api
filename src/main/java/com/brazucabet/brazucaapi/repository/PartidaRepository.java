package com.brazucabet.brazucaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brazucabet.brazucaapi.entity.Partida;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long> {

}
