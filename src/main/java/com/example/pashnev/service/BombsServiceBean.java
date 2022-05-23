package com.example.pashnev.service;

import com.example.pashnev.domain.Bombs;
import com.example.pashnev.repository.BombsRepository;


import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.List;

@Service

public class BombsServiceBean implements BombsService {
    private final BombsRepository bombsRepository;

    public BombsServiceBean(BombsRepository bombsRepository) {
        this.bombsRepository = bombsRepository;
    }

    @Override
    public Bombs create(Bombs myBombs) {
        try {
            if (!myBombs.getCountry().equals("Russia") && myBombs.getCountry() != null) {
                return bombsRepository.save(myBombs);
            }


            throw new IllegalArgumentException("This country can't create bombs");

        } catch (NullPointerException e) {
            return bombsRepository.save(myBombs);
        }

    }


    @Override
    public List<Bombs> show() {

        return bombsRepository.findAll();
    }

    @Override
    public void deleteAll() {
        bombsRepository.deleteAll();
    }

    @Override
    public Bombs findBomb(Integer id) {
        return bombsRepository.getById(id);
    }

    @Override
    public List<Bombs> findBombByCountry(String country) {

        return bombsRepository.findByCountry(country);
    }

    @Override
    public List<Bombs> findBombByWeight(Integer weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("Wrong parameter");
        }
        return bombsRepository.findByWeight(weight);
    }

    @Override
    public Collection<Bombs> deleteBombByCountry(String country) {
        return bombsRepository.deleteByCountry(country);

    }


}
