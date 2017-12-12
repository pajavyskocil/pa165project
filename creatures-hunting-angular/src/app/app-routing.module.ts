import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { MonstersComponent } from './monsters/monsters.component';
import { WeaponsComponent} from './weapons/weapons.component';
import { UsersComponent } from './users/users.component';
import {MonsterDetailComponent} from './monster-detail/monster-detail.component';
import {WeaponDetailComponent} from "./weapon-detail/weapon-detail.component";
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {
    path: 'auth/home',
    component: HomeComponent,
  },
  {
    path: 'auth/monsters',
    component: MonstersComponent
  },
  {
    path: 'auth/monsters/:id',
    component: MonsterDetailComponent
  },
  {
    path: 'auth/weapons',
    component: WeaponsComponent
  },
  {
    path: 'auth/weapons/:id',
    component: WeaponDetailComponent
  },
  { path: 'auth',
    component: LoginComponent
  },
  {
    path: 'auth/users',
    component: UsersComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
