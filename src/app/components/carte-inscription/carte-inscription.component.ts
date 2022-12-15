import {Carte} from '../../models/carte';
import { Component, OnInit } from '@angular/core';
import { CarteService } from 'src/app/services/carte.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-carte-inscription',
  templateUrl: './carte-inscription.component.html',
  styleUrls: ['./carte-inscription.component.css']
})
export class CarteInscriptionComponent implements OnInit {

  carte: Carte  = new Carte();
  submitted = false;
  //idcarte!: Number;
  url!: string | ArrayBuffer | null; 

  constructor(private carteService: CarteService, private route: ActivatedRoute, private router: Router) { }


  ngOnInit(): void {
  }


 newCarte(): void {
    this.submitted = false;
    this.carte = new Carte();
  }
  
  save() {

    this.carteService.createCarte(this.carte)
    .subscribe((data)=> console.log(data), error => console.log(error));
    this.carte = new Carte();
     this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }
  gotoList() {
    this.router.navigate(['/carte/list']);
  }

 
  readUrl(event:any) {
    if (event.target.files && event.target.files[0]) {
      var reader = new FileReader();
  
      reader.onload = (event) => {
        this.url = (<FileReader>event.target).result;
        
      }
  
      reader.readAsDataURL(event.target.files[0]);
    }
  }

  listCarte(){
    this.router.navigate(['/carte/list']);

  }
}
