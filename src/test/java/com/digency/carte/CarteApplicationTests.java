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

	}

}
