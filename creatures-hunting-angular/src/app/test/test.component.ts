import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.scss']
})
export class TestComponent implements OnInit {

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.post('http://localhost:8080/pa165/rest/auth?email=alojz@hlinka.com&password=1234', null, { withCredentials: true }).subscribe(
      data=> console.log('Data: ' + data),
      error => console.log('Error: ' + error)
    )
  }

  logout() {
    this.http.delete('http://localhost:8080/pa165/rest/auth', {withCredentials: true}).subscribe(
      data => console.log('Data: ' + data),
      error => console.log('Error: ' + error)
    )
  }
}
