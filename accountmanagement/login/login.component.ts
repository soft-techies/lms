import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/assets/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  msg = '';
  // email = new FormControl('');
  // password = new FormControl('');
  // loginForm: any;

  email = new FormControl('', [Validators.required, Validators.email]);
  password = new FormControl('', [Validators.required]);
  loginForm: FormGroup;

  constructor(
    private authService: AuthService,
    public router: Router
  ) {
    this.loginForm = new FormGroup({
      email: this.email,
      password: this.password
    });
  }

  ngOnInit() {
  }

  // submit(loginForm: any) {
  //   if (loginForm.valid) {
  //     const email = this.email.value as string;
  //     const password = this.password.value as string;

  //     const uriString = this.authService.login(email, password).subscribe({
  //       next: (res) => {
  //         this.router.navigateByUrl(res.url);
  //       },
  //       error: (err) => {
  //       }
  //     });

  //     console.log("URI " + uriString);
  //   }
  // }

  submit(loginForm: any) {
    if (loginForm.valid) {
      const email = this.email.value as string;
      const password = this.password.value as string;
      this.authService.setUserEmail(email);
      if (this.authService.login(email, password)) {
        localStorage.setItem('isLoggedIn', 'true');
        // Redirect based on user role
        if (this.authService.userRole === 'a') {
          this.router.navigateByUrl('/assignedCourses');
        } else if (this.authService.userRole === 'b') {
          this.router.navigateByUrl('/faculty');
          console.log(this.router.navigateByUrl)
        } else {
          // this.router.navigateByUrl('unknown-role');
        }
      } else {
        alert('Invalid credentials');
      }
    }
  }

  goToRegister() {
    this.router.navigate(['./register']);
  }
}
