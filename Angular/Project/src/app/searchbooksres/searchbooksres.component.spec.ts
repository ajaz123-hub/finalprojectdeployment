import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchbooksresComponent } from './searchbooksres.component';

describe('SearchbooksresComponent', () => {
  let component: SearchbooksresComponent;
  let fixture: ComponentFixture<SearchbooksresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchbooksresComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchbooksresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
