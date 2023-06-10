import { Component } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Plant} from "../model/plant";
import {
  translations
} from '../model/enums';


@Component({
  selector: 'app-flower',
  templateUrl: './flower.component.html',
  styleUrls: ['./flower.component.css']
})
export class FlowerComponent {
  trans = translations;
  plant: Plant;

  constructor(private route: ActivatedRoute) {
    this.plant = history.state.plant;
  }

}
