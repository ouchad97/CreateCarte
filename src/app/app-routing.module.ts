import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CarteInscriptionComponent } from './components/carte-inscription/carte-inscription.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { CartePageComponent } from './components/carte-page/carte-page.components';
import { CommonModule } from '@angular/common';

import { ListCarteComponent } from './components/list-carte/list-carte.component';



const routes: Routes = [
    {path: "",redirectTo: '/carte', pathMatch:'full'},
    { path: "carte", children:[
        { path: "", component: CarteInscriptionComponent},
        { path: "list", component: ListCarteComponent},
        { path: "page/:idCarte", component: CartePageComponent},
      ]
    },
{ path:"**", component:NotFoundComponent}

];

@NgModule({
imports: [RouterModule.forRoot(routes),
    CommonModule,],
exports: [RouterModule]
})
export class AppRoutingModule { }
