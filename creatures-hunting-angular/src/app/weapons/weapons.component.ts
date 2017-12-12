import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material';
import { HttpClient } from '@angular/common/http';
import { Weapon } from '../entity.module';

@Component({
  selector: 'app-weapons',
  templateUrl: './weapons.component.html',
  styleUrls: ['./weapons.component.scss']
})
export class WeaponsComponent implements OnInit {

  displayedColumns = ['id', 'name', 'type', 'range', 'magazineCapacity', 'edit', 'remove'];
  showWeapons : boolean = false;
  weapons : Weapon[] = [];
  dataSource : MatTableDataSource<Weapon>;


  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.loadWeapons();
  }

  loadWeapons(){
    this.http.get<Weapon[]>('http://localhost:8080/pa165/rest/weapons').subscribe(
      data => {
        this.weapons = data;
        this.dataSource = new MatTableDataSource(this.weapons);
        console.log('Weapons loaded');
        console.log(data);
        this.showWeapons = true;
      },
      error => {
        console.log(error);
        alert(error.message);
      }
    );
  }

  removeWeapon(id){
    this.http.delete('http://localhost:8080/pa165/rest/weapons/delete/' + id ,  {responseType: 'text'}).subscribe(
      data => {
        this.loadWeapons();
      },
      error => {
        console.log(error);
        alert(error.message);
      }
    );
  }
}
