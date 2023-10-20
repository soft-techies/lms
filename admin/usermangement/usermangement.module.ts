import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsermangementComponent } from './usermangement.component';
import { RouterModule, Routes } from '@angular/router';
import { FacultyComponent } from './faculty/faculty.component';
import { UserComponent } from './user/user.component';
import { ContentProviderComponent } from './content-provider/content-provider.component';

const routes: Routes = [
  { path: 'faculty', component: FacultyComponent },
  { path: 'contentprovider', component: ContentProviderComponent },
  { path: 'user', component: UserComponent },
];

@NgModule({
  declarations: [
    UsermangementComponent,
    UserComponent,
    ContentProviderComponent,
    FacultyComponent
  ],
  imports: [
    CommonModule,
    [RouterModule.forChild(routes)],
  ],
  exports: [RouterModule],
})
export class UsermangementModule { }
