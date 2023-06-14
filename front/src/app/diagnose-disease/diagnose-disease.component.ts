import {AfterContentInit, Component, OnInit} from '@angular/core';
import {DiseaseService} from "../service/disease.service";
import {BackwardGroupedDiseases, Disease, Symptom} from "../model/disease";

@Component({
  selector: 'app-diagnose-disease',
  templateUrl: './diagnose-disease.component.html',
  styleUrls: ['./diagnose-disease.component.css']
})
export class DiagnoseDiseaseComponent implements OnInit{

  symptoms:string[] = []

  choosenSymptoms:string[] = []
  isFirstFormVisible: boolean = true;
  isSecondFormVisible: boolean = false;
  isThirdFormVisible: boolean = false;

  groups: BackwardGroupedDiseases[] = []
  topDisease:BackwardGroupedDiseases = new BackwardGroupedDiseases();

  constructor(private service:DiseaseService) {
    // if (history.state.plant !== undefined)
      // service.symptoms(history.state.plant)
  }



  ngOnInit() {
    this.service.symptoms().subscribe((res:any)=>{
      for(let r of res){
        if(r !== undefined)
          this.symptoms.push(r)
      }
    })
  }

  diagnose() {
    this.service.diagnose(this.choosenSymptoms).subscribe(res=>{
      this.isFirstFormVisible = false;
      this.isSecondFormVisible = true;
      this.isThirdFormVisible = false;
      this.groups = res
      var max = 0
      this.topDisease = this.groups[0]
      for(let g of this.groups){
        if(g.symptoms.length > max)
        {
          max = g.symptoms.length
          this.topDisease = g
        }
      }
    })
  }

  showThirdForm() {
    this.isFirstFormVisible = false;
    this.isSecondFormVisible = false;
    this.isThirdFormVisible = true;
  }
}
