import { Component, OnInit } from '@angular/core';
import { RequestService } from '../services/request.service';
import { ResponseModel } from '../model/response.model';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.less']
})
export class MainComponent implements OnInit {

  public date: Date = new Date();
  public dateInfo: ResponseModel;

  constructor(private requestService: RequestService) { }

  ngOnInit() {
  }

  public execute(): void {
    this.requestService.getInfo(this.date.getTime()).subscribe((response: ResponseModel) => {
      this.dateInfo = response;
    })
  }

}
