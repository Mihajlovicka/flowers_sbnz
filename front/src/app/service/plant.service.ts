import {HttpClient, HttpHeaders, HttpResponse} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {PlantCareUser, User} from "../model/user";
import {catchError, map} from "rxjs";
import {Plant} from "../model/plant";

@Injectable()
export class PlantService {

  host: string = 'http://localhost:8080/plant'

  loggedIn:User = new User();

  constructor(private http: HttpClient) {
  }

  new(plant: Plant){
    return this.http.post(this.host + "/new", plant)
  }

  all(){
    return this.http.get<Plant[]>(this.host + "/all")
  }
}
