import { Routes } from '@angular/router';
import { LandingComponent } from './pages/landing/landing.component';

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
  }
];
