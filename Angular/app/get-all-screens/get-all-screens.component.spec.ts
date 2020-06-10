import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllScreensComponent } from './get-all-screens.component';

describe('GetAllScreensComponent', () => {
  let component: GetAllScreensComponent;
  let fixture: ComponentFixture<GetAllScreensComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetAllScreensComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetAllScreensComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
