import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssignedCourseDetailsComponent } from './assigned-course-details.component';

describe('AssignedCourseDetailsComponent', () => {
  let component: AssignedCourseDetailsComponent;
  let fixture: ComponentFixture<AssignedCourseDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AssignedCourseDetailsComponent]
    });
    fixture = TestBed.createComponent(AssignedCourseDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
