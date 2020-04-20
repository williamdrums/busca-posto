import { Component, OnInit } from '@angular/core';
import { animate, state, style, transition, trigger } from '@angular/animations';
// import { element } from '@angular/core/src/render3/instructions';


import { PostoService } from '../service/posto.service';
import { Posto } from '../model/posto';
import { from } from 'rxjs';

@Component({
  selector: 'posto-lista-posto',
  templateUrl: './lista-posto.component.html',
  styleUrls: ['./lista-posto.component.css'],
  animations: [
    trigger('detalheExpandido', [
      state('nao_expandido', style({ height: '0px', minHeight: '0' })),
      state('expandido', style({ height: '*' })),
      transition('expandido <=> nao_expandido', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})
export class ListaPostoComponent implements OnInit {

  dataSource: Array<Posto>;

  // mostra a label na tabela
  colunasExibidas = ['posto', 'etanol', 'gasolina', 'bandeira', 'posicao', 'localizacao'];
  elementoExpandido: Postos | null;
  postoslist: Array<Posto>;

  constructor(private service: PostoService) {
    console.log('lista posto');
    service.getListaPosto();
    this.service.listPosto.subscribe((data) => {

      this.postoslist = data;
      //  console.log(this.postoslist);
      this.dataSource = data;
    });
  }

  ngOnInit() {

  }

}
export interface Postos {
  posto: string;
  posicao: number;
  etanol: string;
  gasolina: string;
  localizacao: string;
  bandeira: string;
}

