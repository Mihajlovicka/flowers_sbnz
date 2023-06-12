import {AfterContentInit, Component} from '@angular/core';
import {Plant} from "../model/plant";
import {ActivatedRoute, Router} from "@angular/router";
import {PlantRec} from "../model/recommend-form";

@Component({
  selector: 'app-recommendations',
  templateUrl: './recommendations.component.html',
  styleUrls: ['./recommendations.component.css']
})
export class RecommendationsComponent{

  recomm:PlantRec[] = []

  constructor(private route: ActivatedRoute, private router:Router) {
    this.recomm = history.state.recomm;
    console.log(this.recomm)
  }

  click(rec: any) {
    this.router.navigate(['/flower'], { state: { rec: rec } });
  }
}
