import { Carte } from '../../models/carte';
import { CarteService } from '../../services/carte.service';
import { Component, ElementRef, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router'; 
//@ts-ignore
import * as html2pdf from 'html2pdf.js'; 

@Component({
  selector: 'app-carte-page',
  templateUrl: './carte-page.component.html',
  styleUrls: ['./carte-page.component.css']
})

export class CartePageComponent  {
  public qrCodeValue!: string;

@ViewChild('content',{static:false}) el!: ElementRef


  public downloadAsPDF() { 
      const opt = {
          margin: 1,
          filename: 'Carte.pdf',
          image: { type: 'jpeg', quality: 1 },
          html2canvas: { scale: 2 },
          jsPDF: { unit: 'mm', format: 'letter', orientation: 'landscape' }
        };
        // Save the PDF
        html2pdf().set(opt).from(this.el.nativeElement).save();
  }


    idCarte!:Number;
    carte!:Carte; 
    width: number;

    constructor(private route: ActivatedRoute,private carteService: CarteService, private router: Router) {
        this.width = 82;
     }

    ngOnInit() {

        this.idCarte = this.route.snapshot.params['idCarte'];
        this.carteService.getCarte(this.idCarte)
        .subscribe(data => {
        console.log(data)
          this.carte = data;

          const items = [{
            'nom': this.carte.nomFR,
            'prenom': this.carte.prenomFR,
            'cin': this.carte.cin,
            'datenaissance': this.carte.datenaissance,
          }];
          this.qrCodeValue = JSON.stringify(items);
          
        }, error => console.log(error));
    

    }

    listCarte(){
      this.router.navigate(['/carte/list']);

    }
 
    qrWidth(val: number) {
      this.width = val;
    }

    
}