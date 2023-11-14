import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ApiModule, BASE_PATH } from 'src/services/swaggerfacturacionAPI';
import { environment } from 'src/environments/environment';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ApiModule
  ],
  providers: [{
    provide: BASE_PATH, useValue : environment.basePath
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
