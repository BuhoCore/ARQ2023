import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EntregaPartidaComponent } from './entrega-partida.component';

describe('EntregaPartidaComponent', () => {
  let component: EntregaPartidaComponent;
  let fixture: ComponentFixture<EntregaPartidaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EntregaPartidaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EntregaPartidaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
