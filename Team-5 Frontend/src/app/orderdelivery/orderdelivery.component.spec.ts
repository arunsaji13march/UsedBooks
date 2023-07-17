import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderdeliveryComponent } from './orderdelivery.component';

describe('OrderdeliveryComponent', () => {
  let component: OrderdeliveryComponent;
  let fixture: ComponentFixture<OrderdeliveryComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [OrderdeliveryComponent]
    });
    fixture = TestBed.createComponent(OrderdeliveryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
