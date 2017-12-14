import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogAppropriateMonsterComponent } from './dialog-appropriate-monster.component';

describe('DialogAppropriateMonsterComponent', () => {
  let component: DialogAppropriateMonsterComponent;
  let fixture: ComponentFixture<DialogAppropriateMonsterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DialogAppropriateMonsterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogAppropriateMonsterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
