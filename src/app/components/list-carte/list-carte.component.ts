import { Carte } from '../../models/carte';
import { CarteService } from '../../services/carte.service';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-carte',
  templateUrl: './list-carte.component.html',
  styleUrls: ['./list-carte.component.css']
})

export class ListCarteComponent implements OnInit {
    
    cartes!: Observable<Carte[]>;

    constructor(private carteService: CarteService, private router: Router) { }
  
    ngOnInit(): void {
        this.reloadData();
      }


      reloadData() {
        this.cartes = this.carteService.getCartesList();
      }
      carteDetails(idcarte: Number){
        this.router.navigate(['/carte/page',idcarte]);
    }

    addNew(){
      this.router.navigate(['/carte']);

    }
}