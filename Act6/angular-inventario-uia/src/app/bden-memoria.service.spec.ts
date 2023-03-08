import { TestBed } from '@angular/core/testing';

import { BDenMemoriaService } from './bden-memoria.service';

describe('BDenMemoriaService', () => {
  let service: BDenMemoriaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BDenMemoriaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
