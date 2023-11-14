import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FacturaResponse, FacturacionAPIService } from 'src/services/swaggerfacturacionAPI';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'facturacioncliente';
  listaFacturas: FacturaResponse[] | undefined;

  constructor(private facturacionAPIService: FacturacionAPIService) {


  }
  ngOnInit() {
    this.facturacionAPIService.list().subscribe({
      next: (resultado) => {
        this.listaFacturas = resultado;
      },
      error: (error: HttpErrorResponse) => {
        if (error.error instanceof ErrorEvent) {
          // Error del lado del cliente
          console.error('Error del lado del cliente:', error.error.message);
        } else {
          // Error del lado del servidor
          console.error(`Error del lado del servidor (código ${error.status}): ${error.error}`);
        }
      }
    ,
      complete: () => { }
    })
  }
}
