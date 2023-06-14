import {HttpClient, HttpHeaders, HttpResponse} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {PlantCareUser, User} from "../model/user";
import {catchError, map} from "rxjs";
import {Plant} from "../model/plant";
import {EnvironmentPreferences, LookPreferences, PlantRec} from "../model/recommend-form";
import {UserService} from "./user.service";
import {BackwardGroupedDiseases} from "../model/disease";

@Injectable()
export class DiseaseService {

  host: string = 'http://localhost:8080/disease'

  constructor(private http: HttpClient,
              private userService: UserService) {
  }

  diagnose(symptoms:string[]) {
    return this.http.post<BackwardGroupedDiseases[]>(this.host + "/diagnose", symptoms)
  }

  symptoms() {
    return this.http.get(this.host + "/get/symptoms")
  }
}
