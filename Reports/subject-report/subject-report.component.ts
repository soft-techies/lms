import { Component,OnInit } from '@angular/core';
import { ApiService } from 'src/assets/services/api.service';

@Component({
  selector: 'app-subject-report',
  templateUrl: './subject-report.component.html',
  styleUrls: ['./subject-report.component.css']
})
export class SubjectReportComponent implements OnInit{

  subjectReportData: any[] = [];
  Heading: any[] = ['Id','Subject','Description'];
 
   constructor(private subjectReportService: ApiService) { }
 
   ngOnInit(): void {
     this.subjectReportService.getReports("subjectReport").subscribe((data: any[]) => {
       this.subjectReportData = data;
     });
   }
}
