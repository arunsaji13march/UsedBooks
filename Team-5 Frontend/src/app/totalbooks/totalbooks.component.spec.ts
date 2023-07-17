import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TotalbooksComponent } from './totalbooks.component';

describe('TotalbooksComponent', () => {
  let component: TotalbooksComponent;
  let fixture: ComponentFixture<TotalbooksComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TotalbooksComponent]
    });
    fixture = TestBed.createComponent(TotalbooksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
