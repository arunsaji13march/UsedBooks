import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookhistoryComponent } from './bookhistory.component';

describe('BookhistoryComponent', () => {
  let component: BookhistoryComponent;
  let fixture: ComponentFixture<BookhistoryComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BookhistoryComponent]
    });
    fixture = TestBed.createComponent(BookhistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
