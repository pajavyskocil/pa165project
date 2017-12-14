import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-monster-create',
  templateUrl: './monster-create.component.html',
  styleUrls: ['./monster-create.component.scss']
})
export class MonsterCreateComponent implements OnInit {

  constructor(private http: HttpClient, private router:Router) {}

  ngOnInit() {
  }

  createMonster(name, height, weight, agility){
    var json = {"name":name, "height":height, "weight":weight, "agility":agility};
    console.log(json);
    this.http.post('http://localhost:8080/pa165/rest/auth/monsters/create', json, {withCredentials: true}).subscribe(
      data => {
        this.router.navigate(['monsters']);
      }, error => {
        console.log(error);
        alert(error.message);
      }
    );

  }
}
