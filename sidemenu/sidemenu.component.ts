import { Component, EventEmitter, Output } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sidemenu',
  templateUrl: './sidemenu.component.html',
  styleUrls: ['./sidemenu.component.scss']
})

export class SidemenuComponent {
   reportsSubButtons = [
    { label: 'Report 1', icon: 'description', action: 'report1Action' },
    { label: 'Report 2', icon: 'description', action: 'report2Action' },
    // Add more subbuttons as needed
  ];
  
  links = [
    // {
    //   path: 'admincourse',
    //   name: 'Admin Course',
    //   icon: 'home'
    // },
    {
      path: 'profile',
      name: 'Profile',
      icon: 'group'
    },
    {
      path: 'form',
      name: 'University Form',
      icon: 'view_list'
    },
    {
      path: 'faculty',
      name: 'Faculty',
      icon: 'group'
    },
    {
      path: 'user',
      name: 'user',
      icon: 'group'
    },
  ]

  @Output() closeEmitter = new EventEmitter()

  constructor(private router: Router) { }

  ngOnInit() {
  }

  closeEventEmitter() {
    this.closeEmitter.emit()
  }

  navigateTo(path: string) {
    this.router.navigate([path])
    this.closeEventEmitter()
  }
  onReportsMenuOpen() {
    // You can add code here to load or update the subbuttons dynamically if needed.
  }
}
