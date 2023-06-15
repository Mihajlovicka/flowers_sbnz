import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {HomeComponent} from "./home/home.component";
import {RegisterComponent} from "./register/register.component";
import {NewFlowerComponent} from "./new-flower/new-flower.component";
import {ProfileComponent} from "./profile/profile.component";
import {FlowersComponent} from "./flowers/flowers.component";
import {FlowerComponent} from "./flower/flower.component";
import {RecommendFormComponent} from "./recommend-form/recommend-form.component";
import {RecommendationsComponent} from "./recommendations/recommendations.component";
import {DiagnoseDiseaseComponent} from "./diagnose-disease/diagnose-disease.component";
import {StatisticComponent} from "./statistic/statistic.component";
import {ProfileDataComponent} from "./profile-data/profile-data.component";

const routes: Routes = [
  {path:'', component: HomeComponent},
  {path:'login', component: LoginComponent},
  {path:'register', component: RegisterComponent},
  {path:'new-flower', component: NewFlowerComponent},
  {path:'profile', component: ProfileComponent},
  {path:'profile-data', component: ProfileDataComponent},
  {path:'flowers', component: FlowersComponent},
  {path:'flower', component: FlowerComponent},
  {path:'recommend-form', component: RecommendFormComponent},
  {path:'recommendations', component: RecommendationsComponent},
  {path:'diagnose', component: DiagnoseDiseaseComponent},
  {path:'statistic', component: StatisticComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
