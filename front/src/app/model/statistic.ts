import {Plant} from "./plant";
import {User} from "./user";
import {Symptom} from "./disease";

export class Statistic{
  id:number=0;
  plant:Plant = new Plant();
  user:User = new User();
  positive:PositiveReview[] = []
  negative:NegativeReview[] = []
}

export class PositiveReview{
  id:number=0;
  date:string = '';
  comment:string='';
}

export class NegativeReview{
  id:number=0;
  date:string = '';
  symptom:Symptom=new Symptom();
  handled:boolean = false;
  dateHandled:string = '';
}

