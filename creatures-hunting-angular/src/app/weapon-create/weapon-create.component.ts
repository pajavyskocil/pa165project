import {Component, Inject, OnInit} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {WeaponsComponent} from "../weapons/weapons.component";
import {Router} from "@angular/router";
@Component({
  selector: 'app-weapon-create',
  templateUrl: './weapon-create.component.html',
  styleUrls: ['./weapon-create.component.scss']
})
export class WeaponCreateComponent implements OnInit {

  @Inject(WeaponsComponent) weapons:WeaponsComponent;
  constructor(private http: HttpClient, private router:Router) {}

  ngOnInit() {
  }

  createWeapon(name, weaponType, range, magazineCapacity){
    var json = {"name": name,"type":weaponType, "range":range, "magazineCapacity":magazineCapacity};
    console.log(json);
    this.http.post('http://localhost:8080/pa165/rest/weapons/create', json).subscribe(
      data => {
        this.router.navigate(['weapons']);
      }, error => {
        console.log(error);
        alert(error.message);
      }
    )

  }
}
