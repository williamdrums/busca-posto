import { EventEmitter, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { environment } from '../../environments/environment.prod';


@Injectable({
    providedIn: 'root'
})
export class MapsService {

    urlMaps: String = environment.apiUrl + 'buscaposto';
    mapa: EventEmitter<any> = new EventEmitter<any>();

    constructor(private http: HttpClient, private routes: Router) { }

    public getListaMapa() {
        this.http.get(this.urlMaps + 'listar').subscribe(data => {
            this.mapa.emit(data);
        })
    }
}