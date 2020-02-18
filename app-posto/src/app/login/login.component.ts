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
  // submetido: boolean = false;
  // loginInvalido: boolean = false;
  usuario: Usuario;
  senhaRequired = false;  
  timeAlert = false;

  constructor(private formBuild: FormBuilder, private rota: Router,private loginService: LoginService) { 
    this.usuario = new Usuario();

    this.loginService.login.subscribe(data => {
      if(data){
        this.rota.navigate(['/lista-posto'])
      }
      else {
        alert('Usuario nao encontrado');
        this.timeAlert = true;
        setTimeout(() => {
            this.timeAlert = false;
          },
          5000);
      }
    })
  }

  login() {
    console.log(this.usuario.email)
    if(this.usuario.senha == ''){
      this.senhaRequired = true;
    }
    else{
      this.loginService.setLogin(this.usuario);
    }

  }

  // onSubmit() {
  //   this.submetido = true;
  //   //aqui chamar os dados do banco
  //   if (this.loginForm.controls.email.value == 'williandrums@gmail.com' && this.loginForm.controls.senha.value == '123') {
  //     this.rota.navigate(['/lista-posto']);//add a pagina que deseja chamar
   
  //   }
  //   else {
  //     this.loginInvalido = true;
  //   }
  // }

  // loginControl = new FormControl('', [Validators.required]);
  // selectFormControl = new FormControl('', Validators.required);
  // opcoes: OpcaoLogin[] = [
  //   {opcao: 'ADM'},
  //   {opcao: 'USUARIO'},
  //   {opcao: 'GERENTE'},
  // ];

  ngOnInit() {
    this.loginForm = this.formBuild.group({
      email: ['', Validators.required],
      senha: ['', Validators.required]
    });
  }

}
