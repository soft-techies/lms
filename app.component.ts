import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/assets/services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],

})
export class AppComponent {
  title = 'lms';
  isOpen: boolean = false;
  username: string | null = null;

  constructor(public authService: AuthService, private router: Router) { }

  toggleMenu() {
    this.isOpen = !this.isOpen
  }

  closeEmitterHandler() {
    this.isOpen = !this.isOpen
  }

  ngOnInit() {
    const isLoggedIn = localStorage.getItem('isLoggedIn');
    if (isLoggedIn === 'true') {
      this.authService.isLoggedIn = true;
    } else {
      this.authService.isLoggedIn = false;
    }
  }

  onLogout() {
    localStorage.removeItem("isLoggedIn");
    this.authService.isLoggedIn = false;
    this.router.navigateByUrl('/login');
  }
  adminName():string | null{
    this.username = this.authService.username;
    return this.username;
  }
}
