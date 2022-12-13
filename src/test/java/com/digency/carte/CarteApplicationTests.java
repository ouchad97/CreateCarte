package com.digency.carte;

import com.digency.carte.dto.CarteRequest;
import com.digency.carte.service.CarteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class CarteApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	CarteService carteService;

	@Test
	public void testaddCarte() {

		CarteRequest carteRequest= new CarteRequest(1L,"TestnomFR","TestnomAR","TestprenomFR","TestprenomAR","Testcin","TestProfession",new Date(2002,10,22),true);
		carteService.createCarte(carteRequest);
		System.out.print(carteRequest.toString());
	}

}
