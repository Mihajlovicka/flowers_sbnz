import {HttpClient, HttpHeaders, HttpResponse} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {PlantCareUser, User} from "../model/user";
import {catchError, map} from "rxjs";
import {Plant} from "../model/plant";
import {EnvironmentPreferences, LookPreferences, PlantRec} from "../model/recommend-form";
import {UserService} from "./user.service";
import {BackwardGroupedDiseases} from "../model/disease";
import {Statistic} from "../model/statistic";

@Injectable()
export class StatisticService {

  host: string = 'http://localhost:8080/statistic'

  constructor(private http: HttpClient,
              private userService: UserService) {
  }


  getStatistic(user: string, id:number) {
    return this.http.get<Statistic>(this.host + "/get/"  + id + "/" + user).pipe(
      catchError((error) => {
        alert(error.error);
        throw error;
      }),
    )
  }

  addPositive(plant: Plant, user: string | null, comment: string) {
    var o = {
      id:plant.id,
      email:user,
      comment:comment
    }
    return this.http.post(this.host + "/positive",o)
  }

  addNegative(plant: Plant, user: string | null, comment: string) {
    var o = {
      id:plant.id,
      email:user,
      comment:comment
    }
    return this.http.post(this.host + "/negative",o)
  }

  handleNegative(plant: Plant, user: string | null, comment: string, date:string) {
    var o = {
      id:plant.id,
      email:user,
      comment:comment,
      date:date
    }
    return this.http.post(this.host + "/negative/handle",o)
  }

  checkUserLevel(email: string) {
    return this.http.get<User>(this.host + "/level/" + email)
  }
}
