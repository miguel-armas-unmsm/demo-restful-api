import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'node_modules/rxjs/dist/types';
import { Generic } from '../models/generic';

@Injectable({
  providedIn: 'root'
})
export abstract class CommonService<T extends Generic> {

  protected baseUrl: string = "";

  protected cabeceras: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json'
  });

  constructor(protected http: HttpClient) { }

  public findAll(): Observable<T[]> {
     return this.http.get<T[]>(this.baseUrl);
  }

  public findById(id: number): Observable<T> {
    return this.http.get<T>(`${this.baseUrl}/${id}`)
  }

  public save(model: T): Observable<T> {
    return this.http.post<T>(this.baseUrl, model, {headers: this.cabeceras});
  }

  public update(model: T): Observable<T> {
    return this.http.put<T>(`${this.baseUrl}/${model.id}`, model, {headers: this.cabeceras});
  }

}
