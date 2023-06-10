import {HttpClient, HttpHeaders, HttpResponse} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {PlantCareUser, User} from "../model/user";
import {catchError, map} from "rxjs";

@Injectable()
export class UserService {

  host: string = 'http://localhost:8080/user'

  loggedIn:User = new User();

  constructor(private http: HttpClient) {
  }

  register(user: User){
    return this.http.post(this.host + "/register", user)
  }

  login(email:string, password:string){
    return this.http.post(this.host + "/login", {email:email, password:password}).pipe(
      catchError((error) => {
        alert(error.error);
        throw error;
      }),
      map((response: any) => {
        this.loggedIn = response;
        return response;
      })
    )
  }
}
