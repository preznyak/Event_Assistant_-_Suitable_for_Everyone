import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Service} from "../../model/service/service";

@Injectable()
export class ServiceService {

  private servicesUrl: string;

  constructor(private http: HttpClient) {
    this.servicesUrl = 'http://localhost:8080/api/service/all';
  }

  public findAll(): Observable<Service[]> {
    return this.http.get<Service[]>(this.servicesUrl);
  }
}
