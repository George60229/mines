package com.example.pashnev.web;

import com.example.pashnev.domain.Bombs;
import com.example.pashnev.service.BombsServiceBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value="/api",produces = MediaType.APPLICATION_JSON_VALUE)

public class BombsController {

    private final BombsServiceBean bombsServiceBean;

    public BombsController(BombsServiceBean bombsServiceBean) {
        this.bombsServiceBean = bombsServiceBean;
    }

    @PostMapping("/bombs")
    @ResponseStatus(HttpStatus.CREATED)
    public Bombs createBombs(@RequestBody Bombs myBomb){
        return bombsServiceBean.create(myBomb);
    }
    @GetMapping("/bombs")
    @ResponseStatus(HttpStatus.OK)
    public List<Bombs> showBombs(){
        return bombsServiceBean.show();
    }
    @DeleteMapping("/bombs")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBombs(){
        bombsServiceBean.deleteAll();
    }
    @GetMapping("/bombs/{id}")
    @ResponseStatus
    public void findBomb(@PathVariable Integer id){
        bombsServiceBean.findBomb(id);
    }

    @GetMapping(value ="/bombs",params = {"country"})
    @ResponseStatus(HttpStatus.OK)
    public Collection<Bombs> findByCountry(String country){
        return bombsServiceBean.findBombByCountry(country);
    }

    @GetMapping(value ="/bombs",params = {"weight"})
    @ResponseStatus(HttpStatus.OK)
    public Collection<Bombs> findByWeight(Integer weight){

            return bombsServiceBean.findBombByWeight(weight);


    }
    @DeleteMapping(value = "/bombs",params = {"country"})
    @ResponseStatus(HttpStatus.OK)
    public Collection<Bombs> deleteByCountry(String country){
        return bombsServiceBean.deleteBombByCountry(country);
    }


}
