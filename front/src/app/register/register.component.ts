import { Component } from '@angular/core';
import { trigger, state, style, transition, animate } from '@angular/animations';
import {
  MaintenanceNeedsTranslations,
  NutrientType,
  NutrientTypeTranslations,
  SpaceNeed,
  SpaceNeedTranslations, Sunlight, SunlightStringValues
} from "../model/enums";
import {
  ConsistencyLevel, ConsistencyLevelTranslations,
  Frequency,
  FrequencyTranslations, PlantCareUser,
  User,
  UserLevel,
  UserLevelTranslations
} from "../model/user";
import {UserService} from "../service/user.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  animations: [
    trigger('formAnimation', [
      state('firstForm', style({
        opacity: 1,
        transform: 'translateX(0)'
      })),
      state('secondForm', style({
        opacity: 1,
        transform: 'translateX(0)'
      })),
      transition('firstForm => secondForm', [
        animate('500ms ease-out', style({
          opacity: 0,
          transform: 'translateX(-100%)'
        })),
        animate('500ms', style({
          opacity: 1,
          transform: 'translateX(0)'
        }))
      ])
    ])
  ]
})
export class RegisterComponent {
  isFirstFormVisible: boolean = true;
  isSecondFormVisible: boolean = false;
  user: User = new User();
  frequencies: string[] = Object.values(FrequencyTranslations);
  levels: string[] =  Object.values(UserLevelTranslations);
  consistencies: string[] =  Object.values(ConsistencyLevelTranslations);

  constructor(private service:UserService) {
  }

  showSecondForm() {
    this.isFirstFormVisible = false;
    this.isSecondFormVisible = true;
  }

  onSubmit() {
    console.log(this.user)
    this.service.register(this.user).subscribe((res => {
      alert("Uspesna registracija")
    }))
  }


  getFrequencyEnumValue(translatedValue: string): Frequency {
    return Object.keys(FrequencyTranslations).find(key => FrequencyTranslations[key] === translatedValue) as Frequency;
  }
  getUserLevelEnumValue(translatedValue: string): UserLevel {
    return Object.keys(UserLevelTranslations).find(key => UserLevelTranslations[key] === translatedValue) as UserLevel;
  }
  getConsistencyEnumValue(translatedValue: string): ConsistencyLevel {
    return Object.keys(ConsistencyLevelTranslations).find(key => ConsistencyLevelTranslations[key] === translatedValue) as ConsistencyLevel;
  }

}
