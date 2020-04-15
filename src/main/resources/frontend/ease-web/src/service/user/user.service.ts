import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../../model/user/user";
import {JsonPipe} from "@angular/common";

@Injectable()
export class UserService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/api/user';
  }

  public findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl.concat("/all"));
  }

  public save(user: User) {
    const headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    return this.http.post<User>(this.usersUrl.concat("/create"), JSON.stringify(user), {headers: headers});
  }
}
