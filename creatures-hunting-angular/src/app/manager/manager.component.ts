import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.scss']
})
export class ManagerComponent implements OnInit {

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  logout() {
    this.http.delete('http://localhost:8080/pa165/rest/auth', {withCredentials: true}).subscribe(
      data => console.log('Data: ' + data),
      error => console.log('Error: ' + error)
    )
  }
}
