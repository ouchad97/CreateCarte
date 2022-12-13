package com.digency.carte.repository;


import com.digency.carte.models.Carte;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarteRepository extends JpaRepository<Carte, Long> {
    Carte findByIdCarte(Long idCarte);
}