import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Usuario } from '../../model/usuario';
import { UsuarioService } from './usuario.service';


@Component({
  selector: 'posto-cadastro-usuario',
  templateUrl: './cadastro-usuario.component.html',
  styleUrls: ['./cadastro-usuario.component.css']
})
export class CadastroUsuarioComponent implements OnInit {

  usuarioForm: FormGroup;
  // submetido: boolean = false;
  loginInvalido: boolean = false;
  usuario: Usuario;


  constructor(private formBuild: FormBuilder, private rota: Router, private serviceUsuario: UsuarioService) {
    this.usuario = new Usuario();
  }

  salvar() {
    this.serviceUsuario.setUsuario(this.usuario)
  }


  ngOnInit() {
    this.usuarioForm = this.formBuild.group({
      nome: ['', Validators.required],
      email: ['', Validators.required],
      senha: ['', Validators.required]
    });
  }

}
