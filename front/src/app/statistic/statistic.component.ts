import {Component} from '@angular/core';
import {Plant} from "../model/plant";
import {PlantService} from "../service/plant.service";
import {ActivatedRoute, Router} from "@angular/router";
import {translations} from "../model/enums";
import {PlantRec, recomTranslations} from "../model/recommend-form";
import {DiseaseService} from "../service/disease.service";
import {UserService} from "../service/user.service";
import {Statistic} from "../model/statistic";
import {StatisticService} from "../service/statistic.service";

@Component({
  selector: 'app-statistic',
  templateUrl: './statistic.component.html',
  styleUrls: ['./statistic.component.css']
})
export class StatisticComponent {


  user: string | null = ''
  plant:Plant = new Plant();
  statistic: Statistic = new Statistic();
  noStatistic: boolean = false;
  positiveComment: string = '';
  symptoms:string[] = []

  chosenSymptom:string = ''
  existingSymptom:any
  existingSymptoms: any[] = []


  constructor(private route: ActivatedRoute, private service: StatisticService,
              private router: Router, private serviceDisease: DiseaseService,
              private usrService: UserService) {
    this.user = usrService.getLogged()
    if (history.state.plant !== undefined && this.user != null && this.user !== '') {
      this.plant = history.state.plant
      service.getStatistic(this.user, history.state.plant.id).subscribe((res) => {
          this.statistic = res
          for(let neg of this.statistic.negative){
            if(!neg.handled){
              this.existingSymptoms.push({symptom:neg.symptom, date:neg.date})
            }
          }
        },
        (error) => {
          this.noStatistic = true;
        })
    }

  }

  ngOnInit() {
    this.serviceDisease.symptoms().subscribe((res:any)=>{
      for(let r of res){
        if(r !== undefined)
          this.symptoms.push(r)
      }
    })
  }


  addPositive() {
    this.service.addPositive(history.state.plant, this.user, this.positiveComment).subscribe((res)=>{
      alert("Dodat komentar!")
    })
  }

  addNegative() {
    this.service.addNegative(history.state.plant, this.user, this.chosenSymptom).subscribe((res)=>{
      alert("Dodat komentar!")
    })
  }

  handleNegative() {
    this.service.handleNegative(history.state.plant, this.user, this.existingSymptom.symptom.symptom, this.existingSymptom.date ).subscribe((res)=>{
      alert("Dodat komentar!")
    })
  }
}
