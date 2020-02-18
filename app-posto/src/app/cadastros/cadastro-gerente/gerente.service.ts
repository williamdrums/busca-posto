import { environment } from "../../../environments/environment.prod";
import { Router } from "@angular/router";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable, EventEmitter } from "@angular/core";
import { Usuario } from "../../model/usuario";
import { Gerente } from "../../model/gerente";


@Injectable({
    providedIn: 'root'
})
export class GerenteService {
    urlPosto: String = environment.apiUrl;
    listPosto: EventEmitter<any> = new EventEmitter<any>();

    constructor(private http: HttpClient, private routes: Router) { }


    public setUsuario(gerente: Gerente) {
        console.log(gerente.nome)
      
          const body = JSON.stringify(gerente);
      
          const headers = new HttpHeaders().set('Content-Type', 'application/json');
          const options = {
            headers: headers
          };
          this.http.post(this.urlPosto + 'gerente/salvar', body, {
            headers: new HttpHeaders().set('Content-Type', 'application/json')}).subscribe(data => {
            console.log('sdfs');
            
          });
        }
      
    }