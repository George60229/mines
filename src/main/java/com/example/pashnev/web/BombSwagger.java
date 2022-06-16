package com.example.pashnev.web;

import com.example.pashnev.domain.Bombs;
import com.example.pashnev.dto.BombDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Collection;
import java.util.List;

@Tag(name = "Bombs", description = "Bombs API")
public interface BombSwagger {

    @Operation(summary = "This is endpoint to add a new Bombs", description = "Create request to add a new Bomb", tags = {"Bombs"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CREATED"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "409", description = "Notebook already exists")})
    Bombs createBombs(Bombs requestForSave);

    @Operation(summary = "This is endpoint to see all Bombs", description = "Get all bombs", tags = {"Bombs"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful")})
    List<Bombs> showBombs();

    @Operation(summary = "This is endpoint to delete all Bombs", description = "Delete all bombs", tags = {"Bombs"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful")})
    void deleteBombs();
    @Operation(summary = "This is endpoint to view bombs by id", description = "Get all bombs by ID", tags = {"Bombs"})

    BombDto findBomb( Integer id);

    @Operation(summary = "This is endpoint to view bombs by Country", description = "Get all bombs by country", tags = {"Bombs"})
    Collection<Bombs> findByCountry(String country);

    @Operation(summary = "This is endpoint to view bombs by Weight", description = "Get all bombs by weight", tags = {"Bombs"})
    Collection<Bombs> findByWeight(Integer weight);

    @Operation(summary = "This is endpoint to delete bombs by Country", description = "Delete all bombs by country", tags = {"Bombs"})
    public Collection<Bombs> deleteByCountry(String country);

}
