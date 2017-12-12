import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Monster, Weapon} from '../entity.module';
import { ActivatedRoute } from '@angular/router';
import {MatTableDataSource} from "@angular/material";

@Component({
  selector: 'app-weapon-detail',
  templateUrl: './weapon-detail.component.html',
  styleUrls: ['./weapon-detail.component.scss']
})
export class WeaponDetailComponent implements OnInit {

  displayedColumns = ['id', 'name', 'agility', 'weight', 'height', 'remove'];
  weaponId: number;
  showWeapon: boolean = false;
  weapon: Weapon;
  weaponType: string;
  appropriateMonsters: Monster[] = [];
  dataSource: MatTableDataSource<Monster>;

  constructor(private http: HttpClient, private route: ActivatedRoute) {
    this.route.params.subscribe(res => this.weaponId = res.id);

  }

  ngOnInit() {
    this.loadData();
  }

  loadData(){
    this.http.get<Weapon>('http://localhost:8080/pa165/rest/weapons/' + this.weaponId).subscribe(
      data => {
        this.weapon = data;
        this.showWeapon = true;
        this.weaponType = data.type == null ? 'null' : data.type;
        this.appropriateMonsters = data.appropriateMonsters;
        this.dataSource = new MatTableDataSource(this.appropriateMonsters);
      });
  }

  addAppropriateMonster(monsterId){
    this.http.put('http://localhost:8080/pa165/rest/weapons/' + this.weaponId + '/addAppropriateMonster?monsterId='+ monsterId ,  null, {responseType: 'text'}).subscribe(
      data => {
        this.loadData();
      }
    )
  }

  removeAppropriateMonster(monsterId){
    this.http.put('http://localhost:8080/pa165/rest/weapons/' + this.weaponId + '/removeAppropriateMonster?monsterId='+ monsterId ,  null, {responseType: 'text'}).subscribe(
      data => {
        this.loadData();
      }
    )
  }

  updateWeapon(name, weaponType, range, magazineCapacity){
    var json = {"id":this.weaponId,"name": name,"type":weaponType, "range":range, "magazineCapacity":magazineCapacity};
    console.log(json);
    this.http.put('http://localhost:8080/pa165/rest/weapons/update/' + this.weaponId, json).subscribe(
      data => {
        this.loadData();
      }
    )
  }

}
