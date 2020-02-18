import { Component, OnInit, ViewChild, EventEmitter } from '@angular/core';
import { Posto } from '../model/posto';
import { } from '@angular/google-maps';

import { MapsService } from './maps.service';
import { Postos } from '../lista-posto/lista-posto.component';


@Component({
  selector: 'posto-api-js-maps',
  templateUrl: './api-js-maps.component.html',
  styleUrls: ['./api-js-maps.component.css']
})
export class ApiJsMapsComponent implements OnInit {

  lat: Number
  lng: Number
  zoom: Number = 14;

  latFinal: number;
  longFinal: number;
  listPosto: EventEmitter<any> = new EventEmitter<any>();

  postolist: Array<Posto>

  dir = undefined;

  constructor(private mapsService: MapsService) {
    if (navigator) {
      navigator.geolocation.getCurrentPosition(pos => {
        this.lng = +pos.coords.longitude;
        this.lat = +pos.coords.latitude;

        return this.getDirection(this.lng, this.lat);
      });
    }
  }

  public getDirection(lng: Number, lat: Number) {

    this.mapsService.getListaPosto()
    this.mapsService.listPosto.subscribe((data) => {
      this.postolist = data;

      for (let i in this.postolist) {
        this.latFinal = parseFloat(this.postolist[i].latitude);
        this.longFinal = parseFloat(this.postolist[i].longitude);
        console.log(this.postolist);
      
      this.dir = {
        origin: { lat: this.lat, lng: this.lng },
        destination: { lat: this.latFinal, lng: this.longFinal }
      }
    }


    });


  }


  ngOnInit() {
  }

}
