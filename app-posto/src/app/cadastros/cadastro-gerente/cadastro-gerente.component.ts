import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Gerente } from '../../model/gerente';
import { GerenteService } from './gerente.service';

@Component({
  selector: 'posto-cadastro-gerente',
  templateUrl: './cadastro-gerente.component.html',
  styleUrls: ['./cadastro-gerente.component.css']
})
export class CadastroGerenteComponent implements OnInit {

 
  gerenteForm: FormGroup;
   gerente: Gerente;


  constructor(private formBuild: FormBuilder, private rota: Router,private serviceGerente: GerenteService) { 
    this.gerente = new Gerente();
  }

  salvar(){
    this.serviceGerente.setUsuario(this.gerente);
  }

  ngOnInit() {
    this.gerenteForm = this.formBuild.group({
      nome: ['', Validators.required],
      email: ['', Validators.required],
      telefone: ['', Validators.required],
      senha: ['', Validators.required]
    });
  }

}
