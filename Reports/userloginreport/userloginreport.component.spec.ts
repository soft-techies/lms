import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserloginreportComponent } from './userloginreport.component';

describe('UserloginreportComponent', () => {
  let component: UserloginreportComponent;
  let fixture: ComponentFixture<UserloginreportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserloginreportComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserloginreportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
