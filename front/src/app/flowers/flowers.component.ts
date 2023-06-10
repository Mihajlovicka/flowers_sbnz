import { Component } from '@angular/core';
import {PlantService} from "../service/plant.service";
import {Plant} from "../model/plant";
import {Router} from "@angular/router";

@Component({
  selector: 'app-flowers',
  templateUrl: './flowers.component.html',
  styleUrls: ['./flowers.component.css']
})
export class FlowersComponent {
  plants:Plant[] = []
  constructor(private service:PlantService, private router:Router){
    service.all().subscribe((res) => {
      this.plants = res
    })
  }

  click(plant:Plant){
    this.router.navigate(['/flower'], { state: { plant: plant } });
  }
}
