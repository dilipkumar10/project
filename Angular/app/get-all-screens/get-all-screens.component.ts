import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-get-all-screens',
  templateUrl: './get-all-screens.component.html',
  styleUrls: ['./get-all-screens.component.css']
})
export class GetAllScreensComponent implements OnInit {
screens;
message:string;
  constructor(private adminService:AdminService) { 
    this.getAllScreens();
  }

  ngOnInit() {
  }
getAllScreens(){
  this.adminService.getAllScreens().subscribe(res=>{
    console.log(res);
    this.screens=res.beans;
  });
}

deleteScreen(screen){
  this.adminService.deleteScreen(screen).subscribe(res=>{
    console.log(res);
    this.message=res.message;
    if(res.statusCode===200){
      this.screens.splice(this.screens.indexOf(screen),1);
    }
  })
}
}
