import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material.module';
import { HomeComponent } from './home/home.component';
import { MonstersComponent } from './monsters/monsters.component';
import { MonsterDetailComponent } from './monster-detail/monster-detail.component';
import { WeaponsComponent} from './weapons/weapons.component';

import { HttpClientModule } from '@angular/common/http';
import {WeaponDetailComponent} from "./weapon-detail/weapon-detail.component";
import {WeaponCreateComponent} from "./weapon-create/weapon-create.component";
import {MonsterCreateComponent} from "./monster-create/monster-create.component";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    MonstersComponent,
    WeaponsComponent,
    MonsterDetailComponent,
    MonsterCreateComponent,
    WeaponDetailComponent,
    WeaponCreateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
