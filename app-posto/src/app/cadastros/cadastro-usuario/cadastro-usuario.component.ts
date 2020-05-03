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
  loginInvalido = false;
  usuario: Usuario;


  constructor(private formBuild: FormBuilder, private rota: Router, private serviceUsuario: UsuarioService) {
    this.usuario = new Usuario();

    this.serviceUsuario.listPosto.subscribe(data => {
      this.usuario = data;
    });
  }

  salvar() {
    this.serviceUsuario.setUsuario(this.usuario);
  }

  editar() {
    this.serviceUsuario.getUsuario(this.usuario);
  }

  ngOnInit() {
    this.usuarioForm = this.formBuild.group({
      id: ['', Validators.required],
      nome: ['', Validators.required],
      email: ['', Validators.required],
      senha: ['', Validators.required]
    });
  }

}
