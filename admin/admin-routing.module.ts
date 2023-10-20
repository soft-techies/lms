import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { FacultyComponent } from './usermangement/faculty/faculty.component';

const usermangementModule = () => import('./usermangement/usermangement.module').then(x => x.UsermangementModule);

const routes: Routes = [
  { path: 'usermangement', loadChildren: usermangementModule },
]

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    [RouterModule.forChild(routes)],
  ],
  exports: [RouterModule],
})
export class AdminRoutingModule { }
