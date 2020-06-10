import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-add-movie',
  templateUrl: './add-movie.component.html',
  styleUrls: ['./add-movie.component.css']
})
export class AddMovieComponent implements OnInit {
message: string;
  constructor(private adminService: AdminService) { }

  ngOnInit() {
  }
  addMovie(form: NgForm) {
    this.adminService.addMovie(form.value).subscribe(data => {
        console.log(data);
        this.message = data.message;
        setTimeout(() => {
          this.message = null;
        },2000);
        form.reset();
      }, err => {
        console.log(err);
      });
    }
}
