import { Routes } from '@angular/router';
import { BodyComponent } from './body/body.component';

export const routes: Routes = [
{ path: '', redirectTo: '/seances', pathMatch: 'full' },
{ path: 'seances', component: BodyComponent },
{ path: 'films', component: BodyComponent },
];
