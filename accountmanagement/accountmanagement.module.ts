import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AccountmanagementComponent } from './accountmanagement.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AccountmanagementRoutingModule } from './accountmanagement-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    AccountmanagementComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    CommonModule,
    AccountmanagementRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class AccountmanagementModule { }
