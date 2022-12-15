package com.digency.carte.controllers;

import com.digency.carte.dto.CarteRequest;
import com.digency.carte.dto.CarteResponse;
import com.digency.carte.models.Carte;
import com.digency.carte.service.Impl.CarteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;


@RestController
@CrossOrigin("http://localhost:4200") //acces from angular port
@RequestMapping("/api/carte")
@RequiredArgsConstructor
public class CarteController {
    @Autowired
    CarteServiceImpl carteServiceImpl;


    @PostMapping
    public ResponseEntity<CarteResponse> createCarte( @RequestBody CarteRequest carteRequest) throws IOException {

        CarteResponse response = carteServiceImpl.createCarte(carteRequest);
            return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }
    @GetMapping(path = "/{idCarte}")
    public ResponseEntity<CarteResponse> getCarteByIdCarte(@PathVariable Long idCarte) {

        CarteRequest carteReq = carteServiceImpl.findCarteByIdCarte(idCarte);
        CarteResponse carteResponse = new CarteResponse();
        BeanUtils.copyProperties(carteReq, carteResponse);

        return new ResponseEntity<CarteResponse>(carteResponse, HttpStatus.OK);

    }


    @GetMapping
    public ResponseEntity<List<CarteResponse>>getCarte(){
        List<CarteRequest> cartes = carteServiceImpl.getAllCartes();
        Type listType = new TypeToken <List<CarteResponse>>() {}.getType();
        List<CarteResponse> cartesResponse = new ModelMapper().map(cartes, listType);
        return new ResponseEntity<List<CarteResponse>>(cartesResponse, HttpStatus.OK);

    }

}
