package com.example.pashnev.web;

import com.example.pashnev.domain.Bombs;
import com.example.pashnev.service.BombsService;
import com.example.pashnev.service.BombsServiceBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value="/api",produces = MediaType.APPLICATION_JSON_VALUE)

public class BombsController {

    private final BombsService bombsService;

    public BombsController(BombsServiceBean bombsService) {
        this.bombsService = bombsService;
    }

    @PostMapping("/bombs")
    @ResponseStatus(HttpStatus.CREATED)
    public Bombs createBombs(@RequestBody Bombs myBomb){
        return bombsService.create(myBomb);
    }
    @GetMapping("/bombs")
    @ResponseStatus(HttpStatus.OK)
    public List<Bombs> showBombs(){
        return bombsService.show();
    }
    @DeleteMapping("/bombs")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBombs(){
        bombsService.deleteAll();
    }
    @GetMapping("/bombs/{id}")
    @ResponseStatus
    public void findBomb(@PathVariable Integer id){
        bombsService.findBomb(id);
    }

    @GetMapping(value ="/bombs",params = {"country"})
    @ResponseStatus(HttpStatus.OK)
    public Collection<Bombs> findByCountry(String country){
        return bombsService.findBombByCountry(country);
    }

    @GetMapping(value ="/bombs",params = {"weight"})
    @ResponseStatus(HttpStatus.OK)
    public String findByWeight(Integer weight){
        try {
            return bombsService.findBombByWeight(weight).toString();
        }catch (IllegalArgumentException e){
           return e.getLocalizedMessage();
        }

    }
    @DeleteMapping(value = "/bombs",params = {"country"})
    @ResponseStatus(HttpStatus.OK)
    public Collection<Bombs> deleteByCountry(String country){
        return bombsService.deleteBombByCountry(country);
    }


}
