import {
  CareLevel,
  MaintenanceNeeds,
  NutrientType,
  PlantLevel,
  PlantResistanceLevel,
  PlantType,
  Season,
  SpaceNeed,
  Sunlight,
  WateringNeeds
} from "./enums";

export class Plant {
  id:number|undefined
  name: string= '';
  score: number= 0.0;
  plantLevel:PlantLevel |undefined;
  careLevel: CareLevel= CareLevel.EASY;
  environment: Environment= new Environment();
  description: Description= new Description();
  maintenance: Maintenance= new Maintenance();
}

export class Environment {
  sunlight: Sunlight[]= [Sunlight.PartialSun];
  humidity: number= 40.0;
  airCirculationSensitivity: boolean= false;
  temperatureMax: number= 100.0;
  temperatureMin: number= 0.0;
  spaceNeed: SpaceNeed= SpaceNeed.COMPACT;
  nutrientType: NutrientType[]= [];
}


export class Description {
  color: string[]= [];
  averagesSize: Size= new Size();
  picture: string= '';
  plantType: PlantType= PlantType.ANNUAL;
  flower: Flower= new Flower();
  seasons: Season[]= [];
}

export class Maintenance {
  wateringFrequency: number= 0; // po broju puta nedeljno nisam stavila
  wateringAmount: string= ''; //nisam stavlia
  wateringNeeds: WateringNeeds= WateringNeeds.AVERAGE;
  pruning: string= '';
  fertilization: string= '';
  plantTransplant: string= '';
  maintenanceNeeds: MaintenanceNeeds= MaintenanceNeeds.LOW;
  resistant: PlantResistanceLevel= PlantResistanceLevel.MODERATELY_RESISTANT;
}

export class Flower {
  hasFlowers:boolean = true;
  floweringSeason:Season[] = [];
}

export class Size {
  widthMin :number = 0.0;
  widthMax:number = 0.0;
  heightMin:number = 0.0;
  heightMax:number = 0.0;
}
