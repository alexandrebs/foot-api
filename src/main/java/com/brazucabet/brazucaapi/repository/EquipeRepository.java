package com.brazucabet.brazucaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brazucabet.brazucaapi.entity.Equipe;
import java.util.Optional;
@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long>{

	
	public Optional<Equipe> findByNomeEquipe(String nomeEquipe);

	public boolean existsByNomeEquipe(String nomeEquipe);                                                                          
}
