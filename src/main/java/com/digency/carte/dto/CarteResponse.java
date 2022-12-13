package com.digency.carte.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarteResponse {
    private Long idCarte;
    /**/
    private String nomFR;
    private String nomAR;
    private String prenomFR;
    private String prenomAR;
    private String cin;
    private String profession;
    private Date datenaissance;
    private String imagetitre;
    private String imagetype;
    private byte[] image;

    public CarteResponse(String s) {
    }
}