package com.example.pashnev.repository;

import com.example.pashnev.domain.Bombs;
import com.example.pashnev.dto.BombDto;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface BombsRepository extends JpaRepository<Bombs,Integer> {

    List<Bombs> findByCountry(String country);

    List<Bombs> findByWeight(Integer weight);

    List<Bombs> deleteByCountry(String country);

}
