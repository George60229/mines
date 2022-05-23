package com.example.pashnev.repository;

import com.example.pashnev.domain.Bombs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface BombsRepository extends JpaRepository<Bombs,Integer> {

    List<Bombs> findByCountry(String country);

    List<Bombs> findByWeight(Integer weight);

    void deleteByCountry(String country);

}
