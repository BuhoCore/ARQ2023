import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SolicitudEntregaComponent } from './solicitud-entrega.component';

describe('SolicitudEntregaComponent', () => {
  let component: SolicitudEntregaComponent;
  let fixture: ComponentFixture<SolicitudEntregaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SolicitudEntregaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SolicitudEntregaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
