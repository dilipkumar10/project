import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllTheatersComponent } from './get-all-theaters.component';

describe('GetAllTheatersComponent', () => {
  let component: GetAllTheatersComponent;
  let fixture: ComponentFixture<GetAllTheatersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetAllTheatersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetAllTheatersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
