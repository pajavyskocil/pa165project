import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material.module';
import { HomeComponent } from './manager/home/home.component';
import { MonstersComponent } from './manager/monsters/monsters.component';
import { MonsterDetailComponent } from './manager/monster-detail/monster-detail.component';
import { WeaponsComponent} from './manager/weapons/weapons.component';

import { HttpClientModule } from '@angular/common/http';
import {WeaponDetailComponent} from "./manager/weapon-detail/weapon-detail.component";
import { TestComponent } from './test/test.component';
import { LoginComponent } from './login/login.component';
import { ManagerComponent } from './manager/manager.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    MonstersComponent,
    WeaponsComponent,
    MonsterDetailComponent,
    WeaponDetailComponent,
    TestComponent,
    LoginComponent,
    ManagerComponent
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
