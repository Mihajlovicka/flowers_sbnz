import {HttpClient, HttpHeaders, HttpResponse} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {PlantCareUser, User} from "../model/user";
import {catchError, map} from "rxjs";
import {Plant} from "../model/plant";
import {EnvironmentPreferences, LookPreferences, PlantRec} from "../model/recommend-form";
import {UserService} from "./user.service";

@Injectable()
export class PlantService {

  host: string = 'http://localhost:8080/plant'

  constructor(private http: HttpClient,
              private userService: UserService) {
  }

  new(plant: Plant){
    return this.http.post(this.host + "/new", plant)
  }

  all(){
    return this.http.get<Plant[]>(this.host + "/all")
  }

  recommend(look: LookPreferences, env: EnvironmentPreferences) {
    return this.http.post<PlantRec>(this.host + "/recommend" , {
      look: look, env:env, user: this.userService.getLogged()
    })
  }

  choose(plant: Plant) {
    return this.http.post(this.host + "/choose", {plant:plant, user:this.userService.getLogged()}).pipe(
      catchError((error) => {
        alert(error.error);
        throw error;
      }),
    )
  }

  allUser() {
    return this.http.get<Plant[]>(this.host + "/all/user/"+this.userService.getLogged())
  }
}
