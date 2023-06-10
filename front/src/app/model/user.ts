import {Season} from "./enums";

export class User{
  email: string ='';
  password: string ='';
  name: string ='';
  surname: string ='';
  plantCareUserForm: PlantCareUser = new PlantCareUser();
  }

export class PlantCareUser{
  userLevel:UserLevel = UserLevel.BEGINNER;
  availabilityFrequency:Frequency = Frequency.DAILY ;
  consistencyLevel:ConsistencyLevel = ConsistencyLevel.FAIRLY_CONSISTENT;
}


export enum Frequency {
  DAILY = 'DAILY',
  EVERY_OTHER_DAY = 'EVERY_OTHER_DAY',
  TWICE_A_WEEK = 'TWICE_A_WEEK',
  ONCE_A_WEEK = 'ONCE_A_WEEK'
}


export const FrequencyTranslations: { [key: string]: string } = {
  [Frequency.DAILY]: 'Dnevno',
  [Frequency.EVERY_OTHER_DAY]: 'Svaki drugi dan',
  [Frequency.TWICE_A_WEEK]: 'Dvaput nedeljno',
  [Frequency.ONCE_A_WEEK]: 'Jednom nedeljno'
};


export enum ConsistencyLevel {
  VERY_CONSISTENT = 'VERY_CONSISTENT',
  FAIRLY_CONSISTENT = 'FAIRLY_CONSISTENT',
  INCONSISTENT = 'INCONSISTENT'
}

export const ConsistencyLevelTranslations: { [key: string]: string } = {
  [ConsistencyLevel.VERY_CONSISTENT]: 'Veoma konzistentan',
  [ConsistencyLevel.FAIRLY_CONSISTENT]: 'Prilcno konzistentan',
  [ConsistencyLevel.INCONSISTENT]: 'Nekonzistentan',
};



export enum UserLevel {
  BEGINNER = 'BEGINNER',
  INTERMEDIATE = 'INTERMEDIATE',
  ADVANCED = 'ADVANCED',
  EXPERT = 'EXPERT'
}



export const UserLevelTranslations: { [key: string]: string } = {
  [UserLevel.BEGINNER]: 'Pocetnik',
  [UserLevel.INTERMEDIATE]: 'Srednje napredan',
  [UserLevel.ADVANCED]: 'Napredan',
  [UserLevel.EXPERT]: 'Ekspert',
};
