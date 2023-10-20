import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { AccountmanagementModule } from './accountmanagement/accountmanagement.module';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';
import { AdminModule } from './admin/admin.module';
import { HomeComponent } from './home/home.component';
import { SidemenuComponent } from './sidemenu/sidemenu.component';
import { MatMenuModule } from '@angular/material/menu';
import {MatListModule} from '@angular/material/list';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import { MatCardModule} from '@angular/material/card';
import {CdkMenuModule} from '@angular/cdk/menu';
import { FormComponent } from './form/form.component';
import { MatExpansionModule } from '@angular/material/expansion';
import { ProfileComponent } from './profile/profile.component';
import { UserprofileComponent } from './profile/userprofile/userprofile.component';
import { AssignedCourseDetailsComponent } from './assigned-course-details/assigned-course-details.component';
import { AssignedCoursesComponent } from './assigned-courses/assigned-courses.component';
import { SampleformComponent } from './form/sampleform/sampleform.component';  

@NgModule({
  declarations: [
    AppComponent,
    SidemenuComponent,
    FormComponent,
    ProfileComponent,
    UserprofileComponent,
    AssignedCourseDetailsComponent,
    AssignedCoursesComponent,
    SampleformComponent
    
  ],
  exports: [RouterModule],
  imports: [
    BrowserModule,
    RouterModule,
    AccountmanagementModule,
    AdminModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
    MatIconModule,
    MatToolbarModule,
    MatMenuModule,
    MatListModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    CdkMenuModule,
    FormsModule,
    MatExpansionModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
