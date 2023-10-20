import { Component } from '@angular/core';
import { ApiService } from 'src/assets/services/api.service';

@Component({
  selector: 'app-examinationreport',
  templateUrl: './examinationreport.component.html',
  styleUrls: ['./examinationreport.component.css']
})
export class ExaminationreportComponent {

  examReportData: any[] = [];
  Heading: any[] = ['Id','Examination Name','Description'];
 
   constructor(private examReportService: ApiService) { }
 
   ngOnInit(): void {
     this.examReportService.getReports("examinationReport").subscribe((data: any[]) => {
       this.examReportData = data;
     });
   }

}
