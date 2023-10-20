import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/assets/services/api.service';

@Component({
  selector: 'app-userloginreport',
  templateUrl: './userloginreport.component.html',
  styleUrls: ['./userloginreport.component.css']
})
export class UserloginreportComponent implements OnInit{

  loginReportData: any[] = [];
  Heading: any[] = ['Id','Email','Description'];
   constructor(private loginReportService: ApiService) { }
 
   ngOnInit(): void {
     this.loginReportService.getReports("loginReport").subscribe((data: any[]) => {
       this.loginReportData = data;
     });
   }

}
