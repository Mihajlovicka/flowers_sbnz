import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DiagnoseDiseaseComponent } from './diagnose-disease.component';

describe('DiagnoseDiseaseComponent', () => {
  let component: DiagnoseDiseaseComponent;
  let fixture: ComponentFixture<DiagnoseDiseaseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DiagnoseDiseaseComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DiagnoseDiseaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
