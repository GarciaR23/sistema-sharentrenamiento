import { Injectable } from '@angular/core';

export interface ProfileState {
  fullName: string;
  specialty: string;
  rate: string;
  selectedShift: string;
  selectedDay: string;
  fromTime: string;
  toTime: string;
  bio: string;
  email: string;
  password: string;
}

@Injectable({
  providedIn: 'root',
})
export class FormStateService {
  profile: ProfileState = {
    fullName: '',
    specialty: '',
    rate: '',
    selectedShift: 'Mañana',
    selectedDay: 'L',
    fromTime: '08:00',
    toTime: '17:00',
    bio: '',
    email: '',
    password: '',
  };
}
