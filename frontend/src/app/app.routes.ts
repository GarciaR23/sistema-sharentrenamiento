import { Routes } from '@angular/router';
import { LandingComponent } from './pages/landing/landing.component';
import { Login } from './pages/form/login/login';
import { Perfil } from './pages/form/perfil/perfil';
import { Certificado } from './pages/form/certificado/certificado';
import { Cuenta } from './pages/form/cuenta/cuenta';
import { Tutor } from './pages/form/tutor/tutor';
import { SeleccionRolComponent } from './pages/form/seleccion-rol/seleccion-rol';
import { FormularioTutor } from './pages/form/formulario-tutor/formulario-tutor';

export const routes: Routes = [
  {
    path: '',
    component: LandingComponent
  },
  {
    path: 'metodologia',
    component: LandingComponent // Será reemplazado por metodologia component
  },
  {
    path: 'testimonios',
    component: LandingComponent // Será reemplazado por testimonios component
  },
  {
    path: 'seguridad',
    component: LandingComponent // Será reemplazado por seguridad component
  },
  {
    path: 'soporte',
    component: LandingComponent // Será reemplazado por soporte component
  },
  {
    path: 'login',
    component: Login
  },
  {
    path: 'formulario',
    component: Perfil
  },
  {
    path: 'certificado',
    component: Certificado
  },
  {
    path: 'cuenta',
    component: Cuenta
  },
  {
  path: 'tutor',
  component: Tutor
},
{
  path: 'seleccion-rol',
  component: SeleccionRolComponent
},
{ path: 'formulario-tutor',
   component: FormularioTutor
}
];
