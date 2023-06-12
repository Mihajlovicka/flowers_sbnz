import { Component } from '@angular/core';
import {Plant} from "../model/plant";
import {PlantService} from "../service/plant.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent {
  plants:Plant[] = []
  constructor(private service:PlantService, private router:Router){
    service.allUser().subscribe((res) => {
      this.plants = res
    })
  }

  click(plant:Plant){
    this.router.navigate(['/flower'], { state: { plant: plant } });
  }
}
