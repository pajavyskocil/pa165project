import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { MonstersComponent } from './monsters/monsters.component';
import { WeaponsComponent} from './weapons/weapons.component';
import {MonsterDetailComponent} from './monster-detail/monster-detail.component';
import {WeaponDetailComponent} from "./weapon-detail/weapon-detail.component";
import {WeaponCreateComponent} from "./weapon-create/weapon-create.component";
import {MonsterCreateComponent} from "./monster-create/monster-create.component";

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'monsters',
    component: MonstersComponent
  },
  {
    path: 'monsters/:id',
    component: MonsterDetailComponent
  },
  {
    path: 'monster',
    component: MonsterCreateComponent
  },
  {
    path: 'weapons',
    component: WeaponsComponent
  },
  {
    path: 'weapons/:id',
    component: WeaponDetailComponent
  },
  {
    path: 'weapon',
    component: WeaponCreateComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
