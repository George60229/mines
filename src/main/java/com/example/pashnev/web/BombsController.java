package com.example.pashnev.web;

import com.example.pashnev.domain.Bombs;
import com.example.pashnev.dto.BombDto;
import com.example.pashnev.service.BombsService;
import com.example.pashnev.service.BombsServiceBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)

public class BombsController implements BombSwagger{

    private final BombsService bombsService;

    public BombsController(BombsServiceBean bombsService) {
        this.bombsService = bombsService;
    }

    @PostMapping("/bombs")
    @ResponseStatus(HttpStatus.CREATED)
    public Bombs createBombs(@RequestBody Bombs myBomb) {
        return bombsService.create(myBomb);
    }

    @GetMapping("/bombs")
    @ResponseStatus(HttpStatus.OK)
    public List<Bombs> showBombs() {
        return bombsService.show();
    }

    @DeleteMapping("/bombs")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBombs() {
        bombsService.deleteAll();
    }

    @GetMapping(value="/bombs/id",params={"id"})
    @ResponseStatus(HttpStatus.OK)
    public BombDto findBomb( Integer id) {
        return bombsService.findBomb(id);
    }

    @GetMapping(value = "/bombs/country",params={"country"})
    @ResponseStatus(HttpStatus.OK)
    public Collection<Bombs> findByCountry(String country) {

        return bombsService.findBombByCountry(country);


    }

    @GetMapping(value = "/bombs/weight", params = {"weight"})
    @ResponseStatus(HttpStatus.OK)
    public Collection<Bombs> findByWeight(Integer weight) {

        return bombsService.findBombByWeight(weight);

    }

    @DeleteMapping(value = "/bombs/country", params = {"country"})
    @ResponseStatus(HttpStatus.OK)
    public Collection<Bombs> deleteByCountry(String country) {
        return bombsService.deleteBombByCountry(country);
    }


}
