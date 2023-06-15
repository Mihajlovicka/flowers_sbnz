import {HttpClient, HttpHeaders, HttpResponse} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {PlantCareUser, User} from "../model/user";
import {catchError, map} from "rxjs";

@Injectable()
export class UserService {

  host: string = 'http://localhost:8080/user'

  constructor(private http: HttpClient) {
  }

  register(user: User) {
    return this.http.post(this.host + "/register", user)
  }

  getUser() {
    return this.http.get<User>(this.host + "/get/" + this.getLogged()).pipe(catchError((error) => {
      alert(error.error);
      throw error;
    }))
  }

  login(email: string, password: string) {
    return this.http.post(this.host + "/login", {email: email, password: password}).pipe(
      catchError((error) => {
        alert(error.error);
        throw error;
      }),
      map((response: any) => {
        localStorage.setItem("user", response.email)
        return response;
      })
    )
  }

  getLogged() {
    if (localStorage.getItem("user") !== undefined && localStorage.getItem("user") !== '')
      return localStorage.getItem("user")
    return null;
  }

  logOut() {
    localStorage.removeItem("user")
  }
}
