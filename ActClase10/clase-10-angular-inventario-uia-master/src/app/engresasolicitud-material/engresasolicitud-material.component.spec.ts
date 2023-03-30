import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EngresasolicitudMaterialComponent } from './engresasolicitud-material.component';

describe('EngresasolicitudMaterialComponent', () => {
  let component: EngresasolicitudMaterialComponent;
  let fixture: ComponentFixture<EngresasolicitudMaterialComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EngresasolicitudMaterialComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EngresasolicitudMaterialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
