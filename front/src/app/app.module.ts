import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './header/header.component';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from "@angular/material/button";
import { LoginComponent } from './login/login.component';
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {FormsModule} from "@angular/forms";
import { HomeComponent } from './home/home.component';
import {RegisterComponent} from "./register/register.component";
import {MatSelectModule} from "@angular/material/select";
import { NewFlowerComponent } from './new-flower/new-flower.component';
import {MatMenuModule} from "@angular/material/menu";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {UserService} from "./service/user.service";
import { HttpClientModule } from '@angular/common/http';
import { ProfileComponent } from './profile/profile.component';
import {PlantService} from "./service/plant.service";
import { FlowersComponent } from './flowers/flowers.component';
import {MatCardModule} from "@angular/material/card";
import { FlowerComponent } from './flower/flower.component';
import {MatTabsModule} from "@angular/material/tabs";
import { RecommendFormComponent } from './recommend-form/recommend-form.component';
import { RecommendationsComponent } from './recommendations/recommendations.component';
import { DiagnoseDiseaseComponent } from './diagnose-disease/diagnose-disease.component';
import {DiseaseService} from "./service/disease.service";
import { StatisticComponent } from './statistic/statistic.component';
import {StatisticService} from "./service/statistic.service";
import { ProfileDataComponent } from './profile-data/profile-data.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    HomeComponent,RegisterComponent, NewFlowerComponent, ProfileComponent, FlowersComponent, FlowerComponent, RecommendFormComponent, RecommendationsComponent, DiagnoseDiseaseComponent, StatisticComponent, ProfileDataComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    MatSelectModule,
    MatMenuModule,
    MatCheckboxModule,
    MatCardModule,
    MatTabsModule
  ],
  providers: [UserService, PlantService, DiseaseService, StatisticService],
  bootstrap: [AppComponent]
})
export class AppModule { }
