import { ApplicationConfig } from '@angular/core';

import { HttpClient, HttpClientModule, provideHttpClient } from '@angular/common/http';
import { routes } from './app.routes';
import { provideRouter } from '@angular/router';


export const appConfig: ApplicationConfig = {
  providers: [provideRouter(routes),provideHttpClient()]
};
