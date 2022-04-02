package com.brazucabet.brazucaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brazucabet.brazucaapi.entity.Equipe;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long>{

}
