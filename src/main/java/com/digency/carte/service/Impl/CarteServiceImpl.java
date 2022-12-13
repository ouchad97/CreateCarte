package com.digency.carte.service.Impl;

import com.digency.carte.dto.CarteRequest;
import com.digency.carte.dto.CarteResponse;
import com.digency.carte.models.Carte;
import com.digency.carte.repository.CarteRepository;
import com.digency.carte.service.CarteService;
import com.digency.carte.util.ImageUtility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarteServiceImpl implements CarteService {
    @Autowired
    CarteRepository carteRepository;

    @Override
    public CarteResponse createCarte(CarteRequest carteRequest, MultipartFile file) throws IOException {

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
                .imagetitre(file.getOriginalFilename())
                .imagetype(file.getContentType())
                .image(ImageUtility.compressImage(file.getBytes()))
                .build();
        carteRepository.save(carteEntity);
        log.info("Carte {} is saved", carteEntity.getIdCarte());

        return new CarteResponse("Image uploaded successfully: " +
                file.getOriginalFilename());
    }

    @Override
    public CarteRequest findCarteByIdCarte(Long idCarte) {
        Carte carteEntity = carteRepository.findByIdCarte(idCarte);
        CarteRequest carteReq = new CarteRequest();
        BeanUtils.copyProperties(carteEntity, carteReq);
        return carteReq;    }
}

