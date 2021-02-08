import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from "./header/header.component";
import { ClientesComponent } from './clientes/clientes.component';
import { ClienteService } from './clientes/cliente.service';
import { RouterModule, Routes} from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { FormComponent } from './clientes/form/form.component';
import { FormsModule } from '@angular/forms';


const routes: Routes = [
  {path:'', component: HomeComponent},
  {path:'clientes', component: ClientesComponent},
  {path:'clientes/form', component: FormComponent},
  {path:'clientes/form/:id', component: FormComponent}
];



@NgModule({
  declarations: [
    AppComponent, 
    HeaderComponent,
    FooterComponent,
    ClientesComponent,
    HomeComponent,
    FormComponent
    
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes)
  
  ],
  providers: [ClienteService],
  bootstrap: [AppComponent]
})
export class AppModule { }
