package com.digency.carte.service;

import com.digency.carte.dto.CarteRequest;
import com.digency.carte.dto.CarteResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CarteService {
    CarteResponse createCarte (CarteRequest carteRequest, MultipartFile file) throws IOException;
    CarteRequest findCarteByIdCarte(Long idCarte);



}
