import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { ListaRotas } from './app.route';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, ROUTES } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CustomMaterialModule } from './material.module';
import { AboutComponent } from './about/about.component';
import { ContatoComponent } from './contato/contato.component';
import { CadastroUsuarioComponent } from './cadastros/cadastro-usuario/cadastro-usuario.component';
import { CadastroGerenteComponent } from './cadastros/cadastro-gerente/cadastro-gerente.component';
import { CadastroPostoComponent } from './cadastros/cadastro-posto/cadastro-posto.component';
import { MatSelectModule } from '@angular/material/select';
import { MatIconModule } from '@angular/material/icon';
import { HeaderComponent } from './header/header.component';
import { ListaPostoComponent } from './lista-posto/lista-posto.component';
import { MatTableModule } from '@angular/material/table';
import { CdkTableModule } from '@angular/cdk/table';
import { ApiJsMapsComponent } from './api-js-maps/api-js-maps.component';
import { CommonModule } from '@angular/common';
import { AgmCoreModule } from '@agm/core';
import { AgmDirectionModule} from 'agm-direction';
import { ServiceComponent } from './service/service.component';




@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AboutComponent,
    ContatoComponent,
    CadastroUsuarioComponent,
    CadastroGerenteComponent,
    CadastroPostoComponent,
    HeaderComponent,
    ListaPostoComponent,
    ApiJsMapsComponent,
    ServiceComponent
   


  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(ListaRotas), // lista de array com as rotas
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    CustomMaterialModule,
    MatSelectModule,
    MatTableModule,
    MatIconModule,
    CdkTableModule,
    CommonModule,
    FormsModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyBsMqJwPtyTYWwo2zrGdUnvnN1Piu9KPfg'// chave de acesso google maps
    }),
    AgmDirectionModule
  ],

  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
