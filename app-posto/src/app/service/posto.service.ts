import { environment } from '../../environments/environment.prod';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Injectable, EventEmitter } from '@angular/core';


@Injectable({
    providedIn: 'root'
})
export class PostoService {
    urlPosto: String = environment.apiUrl + 'buscaposto';
    listPosto: EventEmitter<any> = new EventEmitter<any>();
    postosObject: any;

    constructor(private http: HttpClient, private routes: Router) { }


    public getListaPosto() {
        this.http.get(this.urlPosto + '/listar').subscribe(data => {

            this.listPosto.emit(data);
            this.postosObject = data;

        });
    }

}
