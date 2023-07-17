import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AfterHeaderComponent } from './after-header.component';

describe('AfterHeaderComponent', () => {
  let component: AfterHeaderComponent;
  let fixture: ComponentFixture<AfterHeaderComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AfterHeaderComponent]
    });
    fixture = TestBed.createComponent(AfterHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
