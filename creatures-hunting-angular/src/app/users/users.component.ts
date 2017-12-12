import { Component, OnInit } from '@angular/core';
import {User} from "../entity.module";
import {MatTableDataSource} from "@angular/material";
import { HttpClient } from '@angular/common/http';

@Component({
	selector: 'app-users',
	templateUrl: './users.component.html',
	styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {

  displayedColumns = ['id', 'firstName', 'lastName', 'email', 'role', 'delete', 'switchRole' ];
  showUsers: boolean = false;
  users: User[] = [];
  dataSource: MatTableDataSource<User>;

	constructor(private http: HttpClient) { }

	ngOnInit() {
	  this.loadUsers();
	}

  loadUsers() {
    this.http.get<User[]>('http://localhost:8080/pa165/rest/auth/users/', { withCredentials: true }).subscribe(
      data => {
        this.users = data;
        this.dataSource = new MatTableDataSource(this.users);
        console.log('Users loaded');
        console.log(data);
        this.showUsers = true;
      },
      error => {
        console.log(error);
      });
  }

  deleteUser(id) {
    this.http.delete('http://localhost:8080/pa165/rest/auth/users/' + id,  {responseType: 'text', withCredentials: true}).subscribe(
      data => {
        this.loadUsers();
      }
    );
  }

  setAdmin(id) {
    this.http.put('http://localhost:8080/pa165/rest/auth/users/setAdmin?id=' + id,  null,{responseType: 'text', withCredentials: true}).subscribe(
      data => {
        this.loadUsers();
      },
    error => {
      console.log(error);
    }
    );
  }

  removeAdmin(id) {
    this.http.put('http://localhost:8080/pa165/rest/auth/users/removeAdmin?id=' + id,  null,{responseType: 'text', withCredentials: true}).subscribe(
      data => {
        this.loadUsers();
      },
      error => {
        console.log(error);
      }
    );
  }

  isAdmin(id) {
    this.http.get('http://localhost:8080/pa165/rest/auth/users/isAdmin?id=' + id,  {responseType: 'text', withCredentials: true}).subscribe(
      data => {
        this.loadUsers();
      }
    );
  }

  switchRole(id, role) {
    if(role == "ADMIN") {
      console.log("Removing admin")
      this.removeAdmin(id);
    } else {
      console.log("Setting as admin")
      this.setAdmin(id);
    }
  }




}
