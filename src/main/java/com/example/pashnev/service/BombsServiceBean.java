package com.example.pashnev.service;

import com.example.pashnev.config.MappingBomb;
import com.example.pashnev.domain.Bombs;
import com.example.pashnev.dto.BombDto;
import com.example.pashnev.repository.BombsRepository;


import com.example.pashnev.util.CountryWrongException;
import com.example.pashnev.util.WeightWrongException;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.regex.Pattern;

@Service

public class BombsServiceBean implements BombsService {
    private final BombsRepository bombsRepository;
    private final MappingBomb mappingBomb;
    public BombsServiceBean(BombsRepository bombsRepository, MappingBomb mappingBomb) {
        this.bombsRepository = bombsRepository;
        this.mappingBomb = mappingBomb;
    }

    @Override
    public Bombs create(Bombs myBombs) {
        if(isExist(myBombs)){
            return new Bombs();
        }
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
    public BombDto findBomb(Integer id) {
        return mappingBomb.mapToBombDto(bombsRepository.findById(id).orElse(new Bombs()));

    }

    @Override
    public List<Bombs> findBombByCountry(String country) {
        if(country.equals("Russia")){
            deleteBombByCountry("Russia");
            throw new IllegalArgumentException("All bombs successfully destroyed");
        }
        String regex = "\\D*";
        if(!Pattern.matches(regex, country)){
            throw new CountryWrongException();
        }
        return bombsRepository.findByCountry(country);
    }

    @Override
    public List<Bombs> findBombByWeight(Integer weight) {
        if (weight <= 0) {
            throw new WeightWrongException();
        }
        return bombsRepository.findByWeight(weight);
    }

    @Override
    public Collection<Bombs> deleteBombByCountry(String country) {
        String regex = "\\d";
         if(Pattern.matches(regex, country)){
             throw new CountryWrongException();
         }
        return bombsRepository.deleteByCountry(country);

    }
    public boolean isExist(Bombs myBomb){

        ArrayList myColl = new ArrayList(findBombByCountry(myBomb.getCountry()));
        return myColl.contains(myBomb);



    }

}
