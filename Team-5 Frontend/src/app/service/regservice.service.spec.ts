import { TestBed } from '@angular/core/testing';

import { RegserviceService } from './regservice.service';

describe('RegserviceService', () => {
  let service: RegserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
