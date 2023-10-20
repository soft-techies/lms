import { Component,OnInit } from '@angular/core';
import { AuthService } from 'src/assets/services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrls: ['./userprofile.component.scss']
})
export class UserprofileComponent implements OnInit {


  userProfile: any;
  userImage: any;
  userEmail: string='';
  username: string | null = null;

  constructor(private authService: AuthService, public router: Router) { }

  ngOnInit(): void {
    this.authService.userEmail$.subscribe(email => {
      this.userEmail = email;
      this.getUserProfile(email);
      this.getUserImage(email);
    });
  }

  getUserProfile(email: string): void {
    this.authService.getUserProfile(email)
      .subscribe(data=> {
        this.userProfile = data;
        console.log(this.userProfile);
      });
  }

  getUserImage(email: string): void {
    this.authService.getUserImage(email).subscribe((data: Blob) => {
      const reader = new FileReader();
      reader.onload = (event) => {
        if (event.target) {
          this.userImage = event.target.result as string;
        }
      };
      reader.readAsDataURL(data);
    });
  }
  adminName():string | null{
    this.username = this.authService.username;
    return this.username;
  }
  learner(){
    console.log("learner");
    this.router.navigateByUrl('/profile');
  }

}
