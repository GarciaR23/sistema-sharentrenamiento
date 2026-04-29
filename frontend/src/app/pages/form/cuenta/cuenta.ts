import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink, RouterLinkActive } from '@angular/router';
import { FormStateService } from '../../../services/form-state.service';

@Component({
  selector: 'app-cuenta',
  standalone: true,
  imports: [FormsModule, RouterLink, RouterLinkActive],
  templateUrl: './cuenta.html',
  styleUrls: ['./cuenta.scss'],
})
export class Cuenta {
  constructor(public formState: FormStateService) {}
}
