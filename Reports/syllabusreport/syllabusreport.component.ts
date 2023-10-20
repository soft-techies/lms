import { Component,OnInit } from '@angular/core';
import { ApiService } from 'src/assets/services/api.service';

@Component({
  selector: 'app-syllabusreport',
  templateUrl: './syllabusreport.component.html',
  styleUrls: ['./syllabusreport.component.css']
})
export class SyllabusreportComponent implements OnInit{

  syllabusReportData: any[] = [];
  Heading: any[] = ['Id','Syllabus','Description'];
   constructor(private syllabusReportService: ApiService) { }
 
   ngOnInit(): void {
     this.syllabusReportService.getReports("syllabusReport").subscribe((data: any[]) => {
       this.syllabusReportData = data;
     });
   }
}
