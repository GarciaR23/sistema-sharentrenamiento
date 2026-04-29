import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink, RouterLinkActive } from '@angular/router';
import { FormStateService } from '../../../services/form-state.service';

@Component({
  selector: 'app-perfil',
  standalone: true,
  imports: [FormsModule, RouterLink, RouterLinkActive],
  templateUrl: './perfil.html',
  styleUrls: ['./perfil.scss'],
})
export class Perfil {
  constructor(public formState: FormStateService) {}

  selectDay(day: string) {
    this.formState.profile.selectedDay = day;
  }

  selectShift(shift: string) {
    this.formState.profile.selectedShift = shift;
  }
}
