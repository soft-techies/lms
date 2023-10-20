import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FacultyreportComponent } from './facultyreport.component';

describe('FacultyreportComponent', () => {
  let component: FacultyreportComponent;
  let fixture: ComponentFixture<FacultyreportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FacultyreportComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FacultyreportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
