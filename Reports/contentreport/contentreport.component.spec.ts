import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContentreportComponent } from './contentreport.component';

describe('ContentreportComponent', () => {
  let component: ContentreportComponent;
  let fixture: ComponentFixture<ContentreportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContentreportComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ContentreportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
