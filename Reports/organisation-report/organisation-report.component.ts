import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/assets/services/api.service';

@Component({
  selector: 'app-organisation-report',
  templateUrl: './organisation-report.component.html',
  styleUrls: ['./organisation-report.component.css']
})
export class OrganisationReportComponent implements OnInit {

  organisationReportData: any[] = [];
  Heading: any[] = ['Id','Organisation','Description'];
   constructor(private organisationReportService: ApiService) { }
 
   ngOnInit(): void {
     this.organisationReportService.getReports("organisationReport").subscribe((data: any[]) => {
       this.organisationReportData = data;
     });
   }

}
