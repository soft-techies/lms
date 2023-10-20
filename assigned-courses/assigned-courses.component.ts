import { Component } from '@angular/core';
import { ApiService } from 'src/assets/services/api.service';

@Component({
  selector: 'app-assigned-courses',
  templateUrl: './assigned-courses.component.html',
  styleUrls: ['./assigned-courses.component.scss']
})
export class AssignedCoursesComponent {

  UserContentData: any[] = [];
  constructor(private UserContentService: ApiService) { }
  ngOnInit(): void {
    this.UserContentService.getUserContent().subscribe((data: any[]) => {
      this.UserContentData = data;
      console.log(this.UserContentData);
    });
  }

}
