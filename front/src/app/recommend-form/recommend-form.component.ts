import { Component } from '@angular/core';
import {UserService} from "../service/user.service";
import {
  EnvironmentPreferences,
  LookPreferences,
  PositionTranslations,
  RoomTranslations,
  recomTranslations
} from "../model/recommend-form";
import {
  boje,
  PlantType,
  PlantTypeTranslations,
  Season,
  SeasonTranslations,
  Sunlight,
  SunlightStringValues
} from "../model/enums";
import {PlantService} from "../service/plant.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-recommend-form',
  templateUrl: './recommend-form.component.html',
  styleUrls: ['./recommend-form.component.css']
})
export class RecommendFormComponent {
  isFirstFormVisible: boolean = true;
  isSecondFormVisible: boolean = false;
  tran = recomTranslations;
  seasons:string[] = Object.values(SeasonTranslations);
  plantTypes: string[] = Object.values(PlantTypeTranslations);
  colors: string[] = boje;
  sunlights: string[] = Object.values(SunlightStringValues);
  rooms: string[] = Object.values(RoomTranslations);
  positions: string[] = Object.values(PositionTranslations);


  look:LookPreferences = new LookPreferences();
  env: EnvironmentPreferences = new EnvironmentPreferences()

  constructor(private service:PlantService, private router:Router) {
  }

  showSecondForm() {
    this.isFirstFormVisible = false;
    this.isSecondFormVisible = true;
  }

  onSubmit() {
    this.service.recommend(this.look, this.env).subscribe((res => {
      this.router.navigate(['/recommendations'], { state: { recomm: res } });
    }))
  }


  getPlantTypeEnumValue(translatedValue: string): PlantType {
    return Object.keys(PlantTypeTranslations).find(key => PlantTypeTranslations[key] === translatedValue) as PlantType;
  }

  getSeasonsEnumValue(translatedValue: string): Season {
    return Object.keys(SeasonTranslations).find(key => SeasonTranslations[key] === translatedValue) as Season;
  }

  getSunlightEnumValue(translatedValue: string): Sunlight {
    return Object.keys(SunlightStringValues).find(key => SunlightStringValues[key] === translatedValue) as Sunlight;
  }

}
