package com.digency.carte.service.Impl;

import com.digency.carte.dto.CarteRequest;
import com.digency.carte.dto.CarteResponse;
import com.digency.carte.models.Carte;
import com.digency.carte.repository.CarteRepository;
import com.digency.carte.service.CarteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarteServiceImpl implements CarteService {
    @Autowired
    CarteRepository carteRepository;

    @Override
    public CarteResponse createCarte(CarteRequest carteRequest) throws IOException {

        Carte carteEntity = Carte.builder()
                .idCarte(carteRequest.getIdCarte())
                .nomFR(carteRequest.getNomFR())
                .nomAR(carteRequest.getNomAR())
                .prenomFR(carteRequest.getPrenomFR())
                .prenomAR(carteRequest.getPrenomAR())
                .cin(carteRequest.getCin())
                .profession(carteRequest.getProfession())
                .datenaissance(carteRequest.getDatenaissance())
                .typeCarte(carteRequest.getTypeCarte())
                .imageFile(carteRequest.getImageFile())
                .build();
        carteRepository.save(carteEntity);
        log.info("Carte {} is saved", carteEntity.getIdCarte());

        return new CarteResponse("Carte est bien crée");
    }

    @Override
    public CarteRequest findCarteByIdCarte(Long idCarte) {
        Carte carteEntity = carteRepository.findByIdCarte(idCarte);
        CarteRequest carteReq = new CarteRequest();
        BeanUtils.copyProperties(carteEntity, carteReq);
        return carteReq;
    }

    @Override
    public List<CarteRequest> getAllCartes() {
        List<Carte> cartes = (List<Carte>)carteRepository.findAll();
        Type listType = new TypeToken<List<CarteRequest>>() {}.getType();
        List<CarteRequest> cartereq = new ModelMapper().map(cartes, listType);
        return cartereq;
    }



}

