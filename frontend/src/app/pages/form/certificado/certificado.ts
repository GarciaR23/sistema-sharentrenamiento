import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';
import { FileService } from '../../../services/fileservice';

@Component({
  selector: 'app-certificado',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './certificado.html',
  styleUrls: ['./certificado.scss'],
})
export class Certificado {

  private fileTmp: any;

  // constructor(private fileService: FileService) {}


  getFile($event: any):void {
    //Captura de archivo
    const [ file ] = $event.target.files;
    this.fileTmp = {
      fileRaw: file,
      fileName: file.name,
    }

  }
}
