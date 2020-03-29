import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ResponseModel } from '../model/response.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RequestService {

  public apiHost: string = "http://localhost:8080/"

  constructor(private http: HttpClient) { }

  public getInfo(date:number) : Observable<ResponseModel> {
    return this.http.get<ResponseModel>(this.apiHost + 'date/info?date=' + date);
  }


}
