package com.digency.carte.controllers;

import com.digency.carte.dto.CarteRequest;
import com.digency.carte.dto.CarteResponse;
import com.digency.carte.service.Impl.CarteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin
@RequestMapping("/api/carte")
@RequiredArgsConstructor
public class CarteController {
    private final CarteServiceImpl carteServiceImpl;




    @RequestMapping(
            method = POST,
            consumes = {MediaType.ALL_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<?> createCarte( CarteRequest carteRequest,
            final @RequestParam("image") MultipartFile file) throws IOException {

        CarteResponse response = carteServiceImpl.createCarte(carteRequest,file);
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
}
