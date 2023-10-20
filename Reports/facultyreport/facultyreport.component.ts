import { Component,OnInit} from '@angular/core';
import { ApiService } from 'src/assets/services/api.service';

@Component({
  selector: 'app-facultyreport',
  templateUrl: './facultyreport.component.html',
  styleUrls: ['./facultyreport.component.css']
})
export class FacultyreportComponent implements OnInit {

  facultyReportData: any[] = [];
  Heading: any[] = ['Id','Faculty','Description'];
 
   constructor(private facultyReportService: ApiService) { }
 
   ngOnInit(): void {
     this.facultyReportService.getReports("facultyReport").subscribe((data: any[]) => {
       this.facultyReportData = data;
     });
   }

}
