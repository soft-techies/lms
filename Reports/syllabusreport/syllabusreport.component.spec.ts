import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SyllabusreportComponent } from './syllabusreport.component';

describe('SyllabusreportComponent', () => {
  let component: SyllabusreportComponent;
  let fixture: ComponentFixture<SyllabusreportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SyllabusreportComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SyllabusreportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
