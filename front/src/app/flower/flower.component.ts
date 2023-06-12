import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Plant} from "../model/plant";
import {
  translations
} from '../model/enums';
import {PlantRec, recomTranslations} from "../model/recommend-form";
import {PlantService} from "../service/plant.service";


@Component({
  selector: 'app-flower',
  templateUrl: './flower.component.html',
  styleUrls: ['./flower.component.css']
})
export class FlowerComponent {
  trans = translations;
  rectrans = recomTranslations;
  plant: Plant=new Plant();
  rec:PlantRec|undefined;

  constructor(private route: ActivatedRoute, private service:PlantService,
              private router:Router) {
    if(history.state.plant !== undefined)
      this.plant = history.state.plant
    if(history.state.rec !== undefined){
      this.rec = history.state.rec
      if(this.rec?.plant)
        this.plant = this.rec?.plant
    }
  }

  choose() {
    this.service.choose(this.plant).subscribe((res) =>{
      alert("Uspesno dodato u vasu kolekciju.")
      this.router.navigate(['/profile']);
    })
  }
}