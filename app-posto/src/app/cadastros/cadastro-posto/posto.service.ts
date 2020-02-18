import { environment } from "../../../environments/environment.prod";
import { Router } from "@angular/router";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable, EventEmitter } from "@angular/core";
import { Usuario } from "../../model/usuario";
import { Posto } from "../../model/posto";


@Injectable({
    providedIn: 'root'
})
export class PostoService {
    urlPosto: String = environment.apiUrl;
    listPosto: EventEmitter<any> = new EventEmitter<any>();

    constructor(private http: HttpClient, private routes: Router) { }


    public setUsuario(posto: Posto) {
        console.log(posto.posto)
      
          const body = JSON.stringify(posto);
      
          const headers = new HttpHeaders().set('Content-Type', 'application/json');
          const options = {
            headers: headers
          };
          this.http.post(this.urlPosto + 'posto/salvar', body, {
            headers: new HttpHeaders().set('Content-Type', 'application/json')}).subscribe(data => {
            console.log('sdfs');
            
          });
        }
      
    }