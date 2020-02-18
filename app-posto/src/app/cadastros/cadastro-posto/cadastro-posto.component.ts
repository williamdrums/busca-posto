import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { Router } from '@angular/router';

export interface Estado {
  nome: string;
}
export interface Cidade {
  nome: string;
}

@Component({
  selector: 'posto-cadastro-posto',
  templateUrl: './cadastro-posto.component.html',
  styleUrls: ['./cadastro-posto.component.css']
})
export class CadastroPostoComponent implements OnInit {


  postoForm: FormGroup;
  //: FormControl;
  // submetido: boolean = false;
  loginInvalido: boolean = false;


  constructor(private formBuild: FormBuilder, private rota: Router) { }


  // onSubmit() {
  //   this.submetido = true;

  //   if (this.postoForm.controls.email.value == '' && this.postoForm.controls.senha.value == '') {
  //     this.rota.navigate(['']);//add a pagina que deseja chamar
  //   }
  //   else {
  //     this.loginInvalido = true;
  //   }
  // }
  estadoControl = new FormControl('', [Validators.required]);
  selectFormControl = new FormControl('', Validators.required);
  estados: Estado[] = [
    { nome: 'MS' },
    { nome: 'MT' },
    { nome: 'SP' },
    { nome: 'RS' }
  ];

  cidadeControl = new FormControl('', [Validators.required]);
  selectCidadeFormControl = new FormControl('', Validators.required);
  cidades: Cidade[] = [
    { nome: 'Campo Grande' },
    { nome: 'Dourados' },
    { nome: 'Três Lagoas' },
    { nome: 'Coxim' }
  ];

  ngOnInit() {
    this.postoForm = this.formBuild.group({
      nome: ['', Validators.required],
      email: ['', Validators.required],
      telefone: ['', Validators.required],
      senha: ['', Validators.required],
      bairro: ['', Validators.required],
      rua: ['', Validators.required],
      numero: ['', Validators.required]
    });
  }

}
