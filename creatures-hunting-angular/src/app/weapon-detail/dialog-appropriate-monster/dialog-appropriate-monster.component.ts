import { Component, OnInit } from '@angular/core';
import {MatDialog} from "@angular/material";

@Component({
  selector: 'app-dialog-appropriate-monster',
  templateUrl: './dialog-appropriate-monster.component.html',
  styleUrls: ['./dialog-appropriate-monster.component.scss']
})
export class DialogAppropriateMonsterComponent implements OnInit {

  constructor(public dialog: MatDialog) { }

  ngOnInit() {
  }

  openDialog():void {

  }
}
