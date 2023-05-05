import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemsNewBajaComponent } from './items-new-baja.component';

describe('ItemsNewBajaComponent', () => {
  let component: ItemsNewBajaComponent;
  let fixture: ComponentFixture<ItemsNewBajaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ItemsNewBajaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ItemsNewBajaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
