import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExaminationreportComponent } from './examinationreport.component';

describe('ExaminationreportComponent', () => {
  let component: ExaminationreportComponent;
  let fixture: ComponentFixture<ExaminationreportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExaminationreportComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ExaminationreportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
