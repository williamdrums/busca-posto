import { environment } from "../../../environments/environment.prod";
import { Router } from "@angular/router";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable, EventEmitter } from "@angular/core";
import { Usuario } from "../../model/usuario";


@Injectable({
    providedIn: 'root'
})
export class UsuarioService {
    urlPosto: String = environment.apiUrl;
    listPosto: EventEmitter<any> = new EventEmitter<any>();

    constructor(private http: HttpClient, private routes: Router) { }


    public setUsuario(usuario: Usuario) {
        console.log(usuario.nome)
      // const obj = {
      //       nome: "Nascimento",
      //       email: "williandrums@gmail.com",
      //       senha: "123"
      //     };
          const body = JSON.stringify(usuario);
      
          const headers = new HttpHeaders().set('Content-Type', 'application/json');
          const options = {
            headers: headers
          };
          this.http.post(this.urlPosto + 'usuario/salvar', body, {
            headers: new HttpHeaders().set('Content-Type', 'application/json')}).subscribe(data => {
            console.log('sdfs');
            
          });
        }
      
    }

