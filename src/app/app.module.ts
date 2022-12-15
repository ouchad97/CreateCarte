import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CarteInscriptionComponent } from './components/carte-inscription/carte-inscription.component';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule} from '@angular/router';
import { CartePageComponent } from './components/carte-page/carte-page.components'; 
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ListCarteComponent } from './components/list-carte/list-carte.component';
import { QRCodeModule } from 'angular2-qrcode';



@NgModule({
  declarations: [
    AppComponent,
    CarteInscriptionComponent,
    CartePageComponent,
    ListCarteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    RouterModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    QRCodeModule 
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule { }
