import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { MatDialogModule } from '@angular/material/dialog';
import { SubpartidasService } from './subpartidas.service';

describe('SubpartidasService', () => {
  let service: SubpartidasService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SubpartidasService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
