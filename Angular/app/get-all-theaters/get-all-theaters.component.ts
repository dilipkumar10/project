import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-all-theaters',
  templateUrl: './get-all-theaters.component.html',
  styleUrls: ['./get-all-theaters.component.css']
})
export class GetAllTheatersComponent implements OnInit {
theaters:Theater[];
message:string;
  constructor(private adminService:AdminService,
        private router:Router) { 
      this.getAllTheaters();
    }

  ngOnInit() {
  }
  getAllTheaters() {
    this.adminService.getAllTheaters().subscribe(response => {
      console.log(response);
      this.theaters = response.beans;

    }, err => {
      console.log(err);
    });
  }

  selectTheater(theater){
    this.router.navigate([`update-theater/${theater.theaterId}`],{
      queryParams:{
        theaterName:theater.theaterName,theaterCity:theater.theaterCity,managerName:theater.managerName,
        managerContact:theater.managerContact
      }
    });
  }

  deletetheater(theater: Theater){
    this.adminService.deleteTheater(theater).subscribe(res=>{
      console.log(res);
      this.message=res.message;
      if(res.statusCode===200){
        this.theaters.splice(this.theaters.indexOf(theater),1);
      }
    });
  }
}
