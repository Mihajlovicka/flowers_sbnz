import { Component } from '@angular/core';
import {User, UserLevel, UserLevelTranslations} from "../model/user";
import {UserService} from "../service/user.service";
import {PlantLevel, PlantLevelValues, Season, SeasonTranslations} from "../model/enums";
import {UserCustomDimension} from "@angular/cli/src/analytics/analytics-parameters";
import {StatisticService} from "../service/statistic.service";

@Component({
  selector: 'app-profile-data',
  templateUrl: './profile-data.component.html',
  styleUrls: ['./profile-data.component.css']
})
export class ProfileDataComponent {

  user: User = new User();

  constructor( private usrService: UserService, private statisticService: StatisticService)
  {
    usrService.getUser().subscribe((res) => {
      this.user = res
    })
  }
  checkLevel() {
    this.statisticService.checkUserLevel(this.user.email).subscribe((res)=>{
      if(res.plantCareUserForm.userLevel == this.user.plantCareUserForm.userLevel)
        alert("Nema promene")
      else {
        alert("Nivo promenjen")
        this.user = res
      }
    })
  }

  getTranslatedPlantLevel(careLevel: UserLevel): string {
    return UserLevelTranslations[careLevel];
  }
}
