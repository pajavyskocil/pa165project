import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogAppropriateMonsterDialogComponent } from './dialog-appropriate-monster-dialog.component';

describe('DialogAppropriateMonsterDialogComponent', () => {
  let component: DialogAppropriateMonsterDialogComponent;
  let fixture: ComponentFixture<DialogAppropriateMonsterDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DialogAppropriateMonsterDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogAppropriateMonsterDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
