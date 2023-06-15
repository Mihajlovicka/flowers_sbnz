import {Component} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Plant} from "../model/plant";
import {
  translations
} from '../model/enums';
import {PlantRec, recomTranslations} from "../model/recommend-form";
import {PlantService} from "../service/plant.service";
import {DiseaseService} from "../service/disease.service";
import {User} from "../model/user";
import {UserService} from "../service/user.service";


@Component({
  selector: 'app-flower',
  templateUrl: './flower.component.html',
  styleUrls: ['./flower.component.css']
})
export class FlowerComponent {
  trans = translations;
  rectrans = recomTranslations;
  plant: Plant = new Plant();
  rec: PlantRec | undefined;
  user:string | null= ''

  constructor(private route: ActivatedRoute, private service: PlantService,
              private router: Router, private serviceDisease: DiseaseService,
              private usrService: UserService) {
    if (history.state.plant !== undefined)
      this.plant = history.state.plant
    if (history.state.rec !== undefined) {
      this.rec = history.state.rec
      if (this.rec?.plant)
        this.plant = this.rec?.plant
    }
    this.user = usrService.getLogged()
  }

  choose() {
    this.service.choose(this.plant).subscribe((res) => {
      if (res == true) {
        alert("Uspesno dodato u vasu kolekciju.")
        this.router.navigate(['/profile']);
      }else alert("Imate vec ovu biljku.")
    })
  }

  diagnose() {
    this.router.navigate(['/diagnose'], { state: { plant: this.plant } });
  }

  statistic() {
    this.router.navigate(['/statistic'], { state: { plant: this.plant } });
  }
}
