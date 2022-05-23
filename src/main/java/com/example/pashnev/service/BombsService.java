package com.example.pashnev.service;

import com.example.pashnev.domain.Bombs;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface BombsService {
    Bombs create(Bombs myBomb);
    List<Bombs> show();
    void deleteAll();
    Bombs findBomb(Integer id);

    List<Bombs>findBombByCountry(String country);
    List<Bombs>findBombByWeight(Integer weight);
    void deleteBombByCountry(String country);
}
