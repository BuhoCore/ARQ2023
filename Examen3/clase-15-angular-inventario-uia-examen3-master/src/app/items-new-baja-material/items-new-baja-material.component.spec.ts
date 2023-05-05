import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemsNewBajaMaterialComponent } from './items-new-baja-material.component';

describe('ItemsNewBajaMaterialComponent', () => {
  let component: ItemsNewBajaMaterialComponent;
  let fixture: ComponentFixture<ItemsNewBajaMaterialComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ItemsNewBajaMaterialComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ItemsNewBajaMaterialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
