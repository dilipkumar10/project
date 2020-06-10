import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-get-all-movies',
  templateUrl: './get-all-movies.component.html',
  styleUrls: ['./get-all-movies.component.css']
})
export class GetAllMoviesComponent implements OnInit {
movies;
message:string;
  constructor(private adminService:AdminService) { 
    this.getAllMovies();
  }

  ngOnInit() {
  }
  getAllMovies(){
    this.adminService.getAllMovies().subscribe(res=>{
      console.log(res);
      this.movies=res.beans;
    });
  }

  deleteMovie(movie){
    this.adminService.deleteMovie(movie).subscribe(res=>{
      console.log(res);
      this.message=res.message;
      if(res.statusCode===200){
        this.movies.splice(this.movies.indexOf(movie),1);
      }
    })
  }
}
