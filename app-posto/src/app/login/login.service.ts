import { EventEmitter, Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Usuario } from '../model/usuario';
import { environment } from '../../environments/environment.prod';


@Injectable({
    providedIn: 'root'
})
export class LoginService {

    urlPosto: String = environment.apiUrl;
    listPosto: EventEmitter<any> = new EventEmitter<any>();
    login: EventEmitter<Boolean> = new EventEmitter<Boolean>();

    // urlLogin: String = environment.apiUrl + '';

    constructor(private http: HttpClient, private routes: Router) { }

    public setLogin(usuario: Usuario) {
        console.log(usuario.email);
        console.log(usuario.senha);
        // const obj = {
        //       nome: "Nascimento",
        //       email: "williandrums@gmail.com",
        //       senha: "123"
        //     };
        const body = JSON.stringify(usuario);

        this.http.post(this.urlPosto + 'login/usuario', body, {
            headers: new HttpHeaders().set('Content-Type', 'application/json')
        }).subscribe(data => {
            // @ts-ignore
            if (data) {
                this.login.emit(true);
            } else {
                this.login.emit(false);
            }


        });
    }
}

