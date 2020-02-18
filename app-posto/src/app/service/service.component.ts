import { Component, OnInit, Injectable, EventEmitter } from '@angular/core';
import { environment } from '../../environments/environment.prod';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Postos } from '../lista-posto/lista-posto.component';
import { PostoService } from './posto.service';


@Component({
  selector: 'posto-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.css']
})

@Injectable({
  providedIn: 'root'
})
export class ServiceComponent implements OnInit {


  //tipo <Posto> é uma interface com os dados que serao inseridos na table
  postos: Array<Postos>;



  //declarando o servico no construtor e recebendo a instancia do framework
  constructor(private postoService: PostoService, private router: Router) {
    this.postoService.listPosto.subscribe((data) => {
      this.postos = data;
      // console.log(this.postoService)
    });
    this.postoService.getListaPosto();
  }

  //inicializa o componente
  ngOnInit() {


  }






}
