package com.example.pashnev.service;

import com.example.pashnev.domain.Bombs;
import com.example.pashnev.dto.BombDto;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service

public interface BombsService {
    Bombs create(Bombs myBomb);
    List<Bombs> show();
    void deleteAll();
    BombDto findBomb(Integer id);

    List<Bombs>findBombByCountry(String country);
    List<Bombs>findBombByWeight(Integer weight);
    Collection<Bombs> deleteBombByCountry(String country);
}
