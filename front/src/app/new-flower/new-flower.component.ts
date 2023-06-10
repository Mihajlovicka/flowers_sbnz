import { Component } from '@angular/core';
import {Plant} from "../model/plant";
import {
  MaintenanceNeeds,
  MaintenanceNeedsTranslations,
  NutrientType,
  NutrientTypeTranslations,
  PlantResistanceLevel,
  PlantResistanceLevelTranslations,
  SpaceNeed,
  SpaceNeedTranslations,
  Sunlight,
  boje,
  SunlightStringValues,
  WateringNeeds,
  WateringNeedsTranslations,
  PlantType,
  PlantTypeTranslations,
  Season,
  SeasonTranslations
} from "../model/enums";
import {PlantService} from "../service/plant.service";

@Component({
  selector: 'app-new-flower',
  templateUrl: './new-flower.component.html',
  styleUrls: ['./new-flower.component.css']
})
export class NewFlowerComponent {
  isFirstFormVisible: boolean = true;
  isSecondFormVisible: boolean = false;
  isThirdFormVisible: boolean = false;
  isFourthFormVisible: boolean = false;
  plant: Plant = new Plant();
  spaces: string[] = Object.values(SpaceNeedTranslations);
  nutrients: string[] = Object.values(NutrientTypeTranslations);
  sunlights: string[] = Object.values(SunlightStringValues);
  waterings: string[] = Object.values(WateringNeedsTranslations);
  maintenances: string[] = Object.values(MaintenanceNeedsTranslations);
  resistants:string[] = Object.values(PlantResistanceLevelTranslations);
  plants:string[] = Object.values(PlantTypeTranslations);
  seasons:string[] = Object.values(SeasonTranslations);
  plantTypes: string[] = Object.values(PlantTypeTranslations);
  colors: string[] = boje;
  isFifthFormVisible: boolean = false;

  constructor(private service:PlantService) {}



  showSecondForm() {
    this.isFirstFormVisible = false;
    this.isSecondFormVisible = true;
    this.isThirdFormVisible = false;
    this.isFourthFormVisible = false;
    this.isFifthFormVisible = false;
  }

  showThirdForm() {
    this.isFirstFormVisible = false;
    this.isSecondFormVisible = false;
    this.isThirdFormVisible = true;
    this.isFourthFormVisible = false;
    this.isFifthFormVisible = false;
  }

  showFourthForm() {
    this.isFirstFormVisible = false;
    this.isSecondFormVisible = false;
    this.isThirdFormVisible = false;
    this.isFourthFormVisible = true;
    this.isFifthFormVisible = false;
  }
  showFifthForm() {
    this.isFirstFormVisible = false;
    this.isSecondFormVisible = false;
    this.isThirdFormVisible = false;
    this.isFourthFormVisible = false;
    this.isFifthFormVisible = true;
  }

  onSubmit() {
    this.service.new(this.plant).subscribe((res)=>{
      alert("Uspesno dodata.")
    })
  }

  getSpaceNeedEnumValue(translatedValue: string): SpaceNeed {
    return Object.keys(SpaceNeedTranslations).find(key => SpaceNeedTranslations[key] === translatedValue) as SpaceNeed;
  }

  getNutrientTypeEnumValue(translatedValue: string): NutrientType {
    return Object.keys(NutrientTypeTranslations).find(key => NutrientTypeTranslations[key] === translatedValue) as NutrientType;
  }

  getSunlightEnumValue(translatedValue: string): Sunlight {
    return Object.keys(SunlightStringValues).find(key => SunlightStringValues[key] === translatedValue) as Sunlight;
  }

  getResistantNeedsEnumValue(translatedValue: string): PlantResistanceLevel {
    return Object.keys(PlantResistanceLevelTranslations).find(key => PlantResistanceLevelTranslations[key] === translatedValue) as PlantResistanceLevel;
  }

  getMaintenaceNeedsEnumValue(translatedValue: string): MaintenanceNeeds {
    return Object.keys(MaintenanceNeedsTranslations).find(key => MaintenanceNeedsTranslations[key] === translatedValue) as MaintenanceNeeds;
  }

  getWateringNeedsEnumValue(translatedValue: string): WateringNeeds {
    return Object.keys(WateringNeedsTranslations).find(key => WateringNeedsTranslations[key] === translatedValue) as WateringNeeds;
  }

  getPlantTypeEnumValue(translatedValue: string): PlantType {
    return Object.keys(PlantTypeTranslations).find(key => PlantTypeTranslations[key] === translatedValue) as PlantType;
  }

  getSeasonsEnumValue(translatedValue: string): Season {
    return Object.keys(SeasonTranslations).find(key => SeasonTranslations[key] === translatedValue) as Season;
  }
}
