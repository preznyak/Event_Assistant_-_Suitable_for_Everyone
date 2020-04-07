import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Event} from "../../model/event/event";

@Injectable()
export class EventService {

  private eventsUrl: string;

  constructor(private http: HttpClient) {
    this.eventsUrl = 'http://localhost:8080/api/event/all';
  }

  public findAll(): Observable<Event[]> {
    return this.http.get<Event[]>(this.eventsUrl);
  }
}
