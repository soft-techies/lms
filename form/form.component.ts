import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import {NgForm} from '@angular/forms'
import { Router } from '@angular/router'

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent {

  uni: {
    name: string;
    location: string; // Ensure that password is of type string
    type: string;
    description: string;
  } = 
  {
    name: '',
    location: '',
    type: '',
    description: ''
  };

  errorMessage: string = '';
  isFormSubmitted: boolean = false;
  submissionError: string = '';

  constructor(private http: HttpClient, private router: Router) { }

  onSubmit(form: NgForm) {
    this.isFormSubmitted = true;
    console.log('hi');
    if (form.invalid) {
      // Display an alert or error message indicating that all fields are required
      this.errorMessage = 'Please fill in all fields.';
      console.error('Please fill in all fields.');
      return;
    }
    const apiUrl = 'http://192.168.200.73:7001/allMaster/saveUniData';

    this.http.post(apiUrl, this.uni, { responseType: 'text' }).subscribe(
      (response) => {
        console.log('Submission successful:', response);
        if(response){
          console.log('successful');
        }
       
      },
      (error) => {
        console.error('Submission error:', error);
        // if (error.error) {
        //   this.registrationError = error.error; // Extract the error message from the response
        // } 
      }
    );
  
  }
}
