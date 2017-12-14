import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './login/login.component';
import {ManagerComponent} from "./manager/manager.component";
import {HomeComponent} from "./manager/home/home.component";
import {MonstersComponent} from "./manager/monsters/monsters.component";
import {WeaponsComponent} from "./manager/weapons/weapons.component";
import {MonsterDetailComponent} from "./manager/monster-detail/monster-detail.component";

const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: '',
    component: ManagerComponent,
    children: [
      {
        path: 'home',
        component: HomeComponent
      },
      {
        path: 'monsters',
        component: MonstersComponent
      },
      {
        path: 'weapons',
        component: WeaponsComponent
      },
      {
        path: 'monsters/:id',
        component: MonsterDetailComponent
      }
    ]
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
