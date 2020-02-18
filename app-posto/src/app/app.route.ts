import { Routes, RouterModule } from "@angular/router";
import { LoginComponent } from "./login/login.component";
import { AboutComponent } from './about/about.component';
import { ContatoComponent } from './contato/contato.component';
import { CadastroUsuarioComponent } from './cadastros/cadastro-usuario/cadastro-usuario.component';
import { CadastroGerenteComponent } from './cadastros/cadastro-gerente/cadastro-gerente.component';
import { CadastroPostoComponent } from './cadastros/cadastro-posto/cadastro-posto.component';
import { ListaPostoComponent } from "./lista-posto/lista-posto.component";
import { ApiJsMapsComponent } from "./api-js-maps/api-js-maps.component";
import { ServiceComponent } from "./service/service.component";


export const ListaRotas: Routes = [
    { path: 'login', component: LoginComponent },
    { path: 'about', component: AboutComponent },
    { path: 'contato', component: ContatoComponent },
    { path: 'cadastro-usuario', component: CadastroUsuarioComponent },
    { path: 'cadastro-gerente', component: CadastroGerenteComponent },
    { path: 'cadastro-posto', component: CadastroPostoComponent },
    { path: 'lista-posto', component: ListaPostoComponent },
    { path: 'mapa', component: ApiJsMapsComponent },
    {path: 'servico', component: ServiceComponent},
    { path: '', component: LoginComponent }

];
