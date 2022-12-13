package com.digency.carte.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_carte")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Carte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarte;

    /**/
    private String nomFR;
    private String nomAR;
    private String prenomFR;
    private String prenomAR;
    private String cin;
    private String profession;
    private Date datenaissance;
    private Boolean typeCarte;
    private String imagetitre;

    private String imagetype;

    @Lob
    private byte[] image;
}
