package com.example.pashnev.config;

import com.example.pashnev.domain.Bombs;
import com.example.pashnev.dto.BombDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MappingBomb {
    public BombDto mapToBombDto(Bombs myBomb){
        BombDto dto = new BombDto();

        dto.setName(myBomb.getName());
        dto.setWeight(myBomb.getWeight());
        return dto;
    }

    public Bombs mapDTOToBomb(BombDto dto){
        Bombs myBomb = new Bombs();

        myBomb.setName(dto.getName());
        myBomb.setWeight(dto.getWeight());
        return myBomb;
    }

}
