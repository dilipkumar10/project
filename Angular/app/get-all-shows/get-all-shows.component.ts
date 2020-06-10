import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-get-all-shows',
  templateUrl: './get-all-shows.component.html',
  styleUrls: ['./get-all-shows.component.css']
})
export class GetAllShowsComponent implements OnInit {
  shows;
  message:string;
  constructor(private adminService: AdminService) { 
    this.getAllShows();
  }

  ngOnInit() {
  }
  getAllShows(){
    this.adminService.getAllShows().subscribe(res=>{
      console.log(res);
      this.shows=res.beans;
    });
  }
}
