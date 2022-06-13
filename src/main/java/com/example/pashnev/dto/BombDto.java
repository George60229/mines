package com.example.pashnev.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.aspectj.bridge.Message;

import javax.validation.constraints.Size;

public class BombDto {




    @NotNull
    private Integer weight;

    @NotNull
    @Size(min = 1,max = 30,message = "Wrong size of name")
    private String name;


    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
