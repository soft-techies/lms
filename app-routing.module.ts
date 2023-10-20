import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from 'src/assets/auth/auth.gurd';
import { FormComponent } from './form/form.component';
import { ProfileComponent } from './profile/profile.component';
import { UserprofileComponent } from './profile/userprofile/userprofile.component';
import { AssignedCourseDetailsComponent } from './assigned-course-details/assigned-course-details.component';
import { AssignedCoursesComponent } from './assigned-courses/assigned-courses.component';

const accountModule = () => import('./accountmanagement/accountmanagement.module').then(x => x.AccountmanagementModule);
const adminModule = () => import('./admin/admin.module').then(x => x.AdminModule);

const routes: Routes = [
  {path:'form',component:FormComponent},
  {path:'profile',component:ProfileComponent },
  {path:'userprofile',component:UserprofileComponent },
  {path:'coursedetails',component:AssignedCourseDetailsComponent },
  {path:'assignedCourses',component:AssignedCoursesComponent},
  { path: 'admin', loadChildren: adminModule, canActivate: [AuthGuard] },
  { path: 'account', loadChildren: accountModule },
  
  // otherwise redirect to home
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
