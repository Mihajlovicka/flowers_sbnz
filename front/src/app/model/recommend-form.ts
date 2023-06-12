import {
  boje,
  CareLevel,
  CareLevelValues, MaintenanceNeeds,
  NutrientType, PlantResistanceLevel, PlantResistanceLevelTranslations,
  PlantType,
  Season,
  SpaceNeed,
  Sunlight,
  SunlightStringValues, WateringNeeds
} from "../model/enums"
import {Flower, Plant, Size} from "./plant";


export interface PlantRec {
  plant: Plant;
  points: number;
  fit: number;
  compatible: boolean;
  potSize: string;
  potTypes: PotType[];
}

export class LookPreferences{
  color:string[] = []
  size:Size = new Size();
  seasons: Season[] = []
  plantType:PlantType = PlantType.ANNUAL;
  flower:Flower = new Flower()
}

export class EnvironmentPreferences{
  sunlight:Sunlight[] = []
  position:Position = Position.Other
  room:Room = Room.LivingRoom
}


export enum Room {
  LivingRoom = 'LivingRoom',
  Bedroom = 'Bedroom',
  Office = 'Office',
  Kitchen = 'Kitchen',
  Bathroom = 'Bathroom',
  Other = 'Other'
}

export const RoomTranslations: { [key: string]: string } = {
  [Room.LivingRoom]: 'Dnevna soba',
  [Room.Bedroom]: 'Spavaća soba',
  [Room.Office]: 'Kancelarija',
  [Room.Kitchen]: 'Kuhinja',
  [Room.Bathroom]: 'Kupatilo',
  [Room.Other]: 'Drugo'
};

export enum Position {
  Window = 'Window',
  ByDoor = 'ByDoor',
  Corner = 'Corner',
  Other = 'Other'
}



export const PositionTranslations: { [key: string]: string } = {
  [Position.Window]: 'Prozor',
  [Position.ByDoor]: 'Pored vrata',
  [Position.Corner]: 'U uglu',
  [Position.Other]: 'Drugo/nije bitno/ne znam'
}


export enum PotType {
  TERRACOTTA="TERRACOTTA",
  PLASTIC="PLASTIC",
  CERAMIC="CERAMIC"
}

export const PotTypeTranslations: { [key: string]: string } = {
  [PotType.PLASTIC]: 'Plasticna',
  [PotType.CERAMIC]: 'Keramicka',
  [PotType.TERRACOTTA]: 'Terakota'
}


const translationMethods = {
  getTranslatedPosition(translatedValue: string): Position {
    return Object.keys(PositionTranslations).find(key => PositionTranslations[key] === translatedValue) as Position;
  },
  getTranslatedRoom(translatedValue: string): Room {
    return Object.keys(RoomTranslations).find(key => RoomTranslations[key] === translatedValue) as Room;
  },
  getTranslatedPot(translatedValue: string): PotType {
    return Object.keys(PotTypeTranslations).find(key => PotTypeTranslations[key] === translatedValue) as PotType;
  },
  getTranslatedPotFromEnum(plantResistanceLevel: PotType): string {
    return PotTypeTranslations[plantResistanceLevel];
  }
}

const enumProperties = {
  Room,Position
};

export const recomTranslations = {
  ...enumProperties,
  ...translationMethods
};
