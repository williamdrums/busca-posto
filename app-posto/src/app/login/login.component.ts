import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from './login.service';
import { Usuario } from '../model/usuario';

// export interface OpcaoLogin{
//   opcao: string;
// }
@Component({
  selector: 'posto-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  usuario: Usuario;
  senhaRequired = false;
  timeAlert = false;

  constructor(private formBuild: FormBuilder, private rota: Router, private loginService: LoginService) {
    this.usuario = new Usuario();

    this.loginService.login.subscribe(data => {
      if (data) {
        this.rota.navigate(['/lista-posto']);
      } else {
        alert('Usuario não encontrado');
        this.timeAlert = true;
        setTimeout(() => {
          this.timeAlert = false;
        },
          5000);
      }
    });
  }

  login() {
    console.log(this.usuario.email);
    if (this.usuario.senha === '') {
      this.senhaRequired = true;
    } else {
      this.loginService.setLogin(this.usuario);
    }

  }

  ngOnInit() {
    this.loginForm = this.formBuild.group({
      email: ['', Validators.required],
      senha: ['', Validators.required]
    });
  }


}
