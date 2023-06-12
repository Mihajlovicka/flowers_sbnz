export enum CareLevel {
  EASY= "EASY",
  MEDIUM = "MEDIUM",
  HARD = "HARD"
}

export const CareLevelValues : { [key: string]: string } = {
  [CareLevel.EASY]: 'Lako',
  [CareLevel.MEDIUM]: 'Srednje tesko',
  [CareLevel.HARD]: 'Tesko',
};

export enum PlantLevel {
  EASY= "EASY",
  MODERATE = "MODERATE",
  HARD = "HARD",
  VERY_HARD = "VERY_HARD"
}

export const PlantLevelValues : { [key: string]: string } = {
  [PlantLevel.EASY]: 'Lak',
  [PlantLevel.MODERATE]: 'Srednje tezak',
  [PlantLevel.HARD]: 'Tezak',
  [PlantLevel.VERY_HARD]: 'Jako tezak',
};



export enum Sunlight {
  FullSun = 'FullSun',
  PartialSun = 'PartialSun',
  Shade = 'Shade'
}

export const SunlightStringValues : { [key: string]: string } = {
  [Sunlight.FullSun]: 'Suncano',
  [Sunlight.PartialSun]: 'Malo sunca',
  [Sunlight.Shade]: 'Hlad'
};

export enum SpaceNeed {
  UNDERGROUND = 'UNDERGROUND',
  COMPACT = 'COMPACT',
  MODERATE = 'MODERATE',
  AGGRESSIVE = 'AGGRESSIVE',
  VERTICAL = 'VERTICAL',
  DENSE = 'DENSE'
}

export const SpaceNeedTranslations : { [key: string]: string } = {
  [SpaceNeed.UNDERGROUND]: 'Podzemni',
  [SpaceNeed.COMPACT]: 'Kompaktan',
  [SpaceNeed.MODERATE]: 'Umjereno širenje',
  [SpaceNeed.AGGRESSIVE]: 'Agresivno širenje',
  [SpaceNeed.VERTICAL]: 'Vertikalni',
  [SpaceNeed.DENSE]: 'Gust'
};


export enum NutrientType {
  NITROGEN = 'NITROGEN',
  PHOSPHORUS = 'PHOSPHORUS',
  POTASSIUM = 'POTASSIUM',
  CALCIUM = 'CALCIUM',
  MAGNESIUM = 'MAGNESIUM',
  SULFUR = 'SULFUR',
  IRON = 'IRON',
  MANGANESE = 'MANGANESE',
  ZINC = 'ZINC',
  COPPER = 'COPPER',
  MOLYBDENUM = 'MOLYBDENUM',
  BORON = 'BORON',
  CHLORINE = 'CHLORINE'
}

export const NutrientTypeTranslations : { [key: string]: string } = {
  [NutrientType.NITROGEN]: 'Azot',
  [NutrientType.PHOSPHORUS]: 'Fosfor',
  [NutrientType.POTASSIUM]: 'Kalijum',
  [NutrientType.CALCIUM]: 'Kalcijum',
  [NutrientType.MAGNESIUM]: 'Magnezijum',
  [NutrientType.SULFUR]: 'Sumpor',
  [NutrientType.IRON]: 'Gvožđe',
  [NutrientType.MANGANESE]: 'Mangan',
  [NutrientType.ZINC]: 'Cink',
  [NutrientType.COPPER]: 'Bakar',
  [NutrientType.MOLYBDENUM]: 'Molibden',
  [NutrientType.BORON]: 'Bor',
  [NutrientType.CHLORINE]: 'Hlor'
};


export enum PlantType {
  ANNUAL = 'ANNUAL',
  PERENNIAL = 'PERENNIAL'
}

export const PlantTypeTranslations : { [key: string]: string } = {
  [PlantType.ANNUAL]: 'Jednogodišnja',
  [PlantType.PERENNIAL]: 'Višegodišnja'
};

export enum Season {
  SPRING = 'SPRING',
  SUMMER = 'SUMMER',
  FALL = 'FALL',
  WINTER = 'WINTER'
}

export const SeasonTranslations: { [key: string]: string } = {
  [Season.SPRING]: 'Proleće',
  [Season.SUMMER]: 'Leto',
  [Season.FALL]: 'Jesen',
  [Season.WINTER]: 'Zima'
};

export enum WateringNeeds {
  LOW = 'LOW',
  AVERAGE = 'AVERAGE',
  HIGH = 'HIGH'
}

export const WateringNeedsTranslations : { [key: string]: string } = {
  [WateringNeeds.LOW]: 'Nisko',
  [WateringNeeds.AVERAGE]: 'Prosečno',
  [WateringNeeds.HIGH]: 'Visoko'
};


export enum MaintenanceNeeds {
  LOW = 'LOW',
  AVERAGE = 'AVERAGE',
  HIGH = 'HIGH'
}

export const MaintenanceNeedsTranslations : { [key: string]: string } = {
  [MaintenanceNeeds.LOW]: 'Nisko',
  [MaintenanceNeeds.AVERAGE]: 'Prosečno',
  [MaintenanceNeeds.HIGH]: 'Visoko'
};

export enum PlantResistanceLevel {
  HIGH_RESISTANT = 'HIGH_RESISTANT',
  MODERATELY_RESISTANT = 'MODERATELY_RESISTANT',
  SENSITIVE = 'SENSITIVE'
}

export const PlantResistanceLevelTranslations: { [key: string]: string } = {
  [PlantResistanceLevel.HIGH_RESISTANT]: 'Visoko otporan',
  [PlantResistanceLevel.MODERATELY_RESISTANT]: 'Umjereno otporan',
  [PlantResistanceLevel.SENSITIVE]: 'Osetljiv'
};

export const boje: string[] = [
  'Crvena',
  'Plava',
  'Zelena',
  'Zuta',
  'Narandzasta',
  'Roza',
  'Ljubicasta',
  'Braon',
  'Crna',
  'Bela',
  'Siva',
  'Teget',
  'Ciklama',
  'Smedja',
  'Zlatna',
  'Srebrna'
];


// Generate enum properties
const enumProperties = {
  CareLevel,
  Sunlight,
  SpaceNeed,
  NutrientType,
  PlantType,
  Season,
  WateringNeeds,
  MaintenanceNeeds,
  PlantResistanceLevel,
  boje,
  PlantLevel
};

// Generate translation methods for each enum
const translationMethods = {
  getTranslatedCareLevel(careLevel: CareLevel): string {
    return CareLevelValues[careLevel];
  },
  getTranslatedSunlight(sunlight: Sunlight): string {
    return SunlightStringValues[sunlight];
  },
  getTranslatedSpaceNeed(spaceNeed: SpaceNeed): string {
    return SpaceNeedTranslations[spaceNeed];
  },
  getTranslatedNutrientType(nutrientType: NutrientType): string {
    return NutrientTypeTranslations[nutrientType];
  },
  getTranslatedPlantType(plantType: PlantType): string {
    return PlantTypeTranslations[plantType];
  },
  getTranslatedSeason(season: Season): string {
    return SeasonTranslations[season];
  },
  getTranslatedWateringNeeds(wateringNeeds: WateringNeeds): string {
    return WateringNeedsTranslations[wateringNeeds];
  },
  getTranslatedMaintenanceNeeds(maintenanceNeeds: MaintenanceNeeds): string {
    return MaintenanceNeedsTranslations[maintenanceNeeds];
  },
  getTranslatedPlantResistanceLevel(plantResistanceLevel: PlantResistanceLevel): string {
    return PlantResistanceLevelTranslations[plantResistanceLevel];
  },
  getTranslatedPlantLevel(careLevel: PlantLevel): string {
    return PlantLevelValues[careLevel];
  },
  getSpaceNeedEnumValue(translatedValue: string): SpaceNeed {
    return Object.keys(SpaceNeedTranslations).find(key => SpaceNeedTranslations[key] === translatedValue) as SpaceNeed;
  },
  getPlantLevelEnumValue(translatedValue: string): PlantLevel {
    return Object.keys(PlantLevelValues).find(key => PlantLevelValues[key] === translatedValue) as PlantLevel;
  },

  getNutrientTypeEnumValue(translatedValue: string): NutrientType {
    return Object.keys(NutrientTypeTranslations).find(key => NutrientTypeTranslations[key] === translatedValue) as NutrientType;
  },

  getSunlightEnumValue(translatedValue: string): Sunlight {
    return Object.keys(SunlightStringValues).find(key => SunlightStringValues[key] === translatedValue) as Sunlight;
  },

  getResistantNeedsEnumValue(translatedValue: string): PlantResistanceLevel {
    return Object.keys(PlantResistanceLevelTranslations).find(key => PlantResistanceLevelTranslations[key] === translatedValue) as PlantResistanceLevel;
  },

  getMaintenaceNeedsEnumValue(translatedValue: string): MaintenanceNeeds {
    return Object.keys(MaintenanceNeedsTranslations).find(key => MaintenanceNeedsTranslations[key] === translatedValue) as MaintenanceNeeds;
  },

  getWateringNeedsEnumValue(translatedValue: string): WateringNeeds {
    return Object.keys(WateringNeedsTranslations).find(key => WateringNeedsTranslations[key] === translatedValue) as WateringNeeds;
  },

  getPlantTypeEnumValue(translatedValue: string): PlantType {
    return Object.keys(PlantTypeTranslations).find(key => PlantTypeTranslations[key] === translatedValue) as PlantType;
  },

  getSeasonsEnumValue(translatedValue: string): Season {
    return Object.keys(SeasonTranslations).find(key => SeasonTranslations[key] === translatedValue) as Season;
  }
};



// Generate translation methods for each enum
const stringValues = {
  spaces: Object.values(SpaceNeedTranslations),
  nutrients: Object.values(NutrientTypeTranslations),
  sunlights: Object.values(SunlightStringValues),
  waterings: Object.values(WateringNeedsTranslations),
  maintenances: Object.values(MaintenanceNeedsTranslations),
  resistants: Object.values(PlantResistanceLevelTranslations),
  plants: Object.values(PlantTypeTranslations),
  seasons: Object.values(SeasonTranslations),
  plantTypes: Object.values(PlantTypeTranslations),
  colors: boje
};


export const translations = {
  ...stringValues,
  ...enumProperties,
  ...translationMethods
};
