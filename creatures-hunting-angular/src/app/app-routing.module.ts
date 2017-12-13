import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { MonstersComponent } from './monsters/monsters.component';
import { WeaponsComponent} from './weapons/weapons.component';
import {MonsterDetailComponent} from './monster-detail/monster-detail.component';
import {WeaponDetailComponent} from "./weapon-detail/weapon-detail.component";
import {TestComponent} from "./test/test.component";

const routes: Routes = [
  {
    path: 'auth/',
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
    component: TestComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
