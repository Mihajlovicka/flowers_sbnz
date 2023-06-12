import { Component } from '@angular/core';
import {Plant} from "../model/plant";
import {
 translations
} from "../model/enums";
import {PlantService} from "../service/plant.service";
import {Router} from "@angular/router";

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
  isFifthFormVisible: boolean = false;

  trans = translations

  constructor(private service:PlantService, private router:Router) {}



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
    this.service.new(this.plant).subscribe((res:any)=>{
      if(res.plantLevel !== undefined)
      alert("Biljka" +res.name +  "je dodata.\nNivo biljke je: " + this.trans.getTranslatedPlantLevel(res.plantLevel) + ".")
      else alert("Biljka dodata.")
      this.router.navigate(['/flowers']);
    })
  }

}
